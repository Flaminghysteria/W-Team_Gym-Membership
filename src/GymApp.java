
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;
import java.io.File;


public class GymApp {
    private static JFrame activeWindow;
    private static boolean wantsTrainer = false;
    private static String selectedPlan = "";
    private static String selectedTrainer = "";
    private static String signedInUser = "";
    private final File file = new File("users.txt");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> safely(GymApp::showWelcome));
    }

    private static void showWelcome() {
        WelcomePage welcome = new WelcomePage();
        replaceButton(welcome, "logInButton", GymApp::showLogin);
        replaceButton(welcome, "startYourFitnessJourneyButton", GymApp::showSignup);
        display(welcome);
    }

    private static void showLogin() {
        GymLogin login = new GymLogin();
        replaceButton(login, "logInButton", () -> {
            String username = field(login, "userName", JTextField.class).getText().trim();
            char[] password = field(login, "passwordField", JPasswordField.class).getPassword();
            try {
                if (username.isEmpty() || password.length == 0) {
                    warn("Please enter both your username and password.");
                    return;
                }
                if (!LocalAccounts.verify(username, password)) {
                    warn("Invalid username or password. Create an account first if you're new.");
                    return;
                }
                signedInUser = username;
                JOptionPane.showMessageDialog(login, "Welcome, " + username + "!");
                showDashboard();
            } catch (IOException | GeneralSecurityException ex) {
                error("Could not check login details", ex);
            } finally {
                Arrays.fill(password, '\0');
            }
        });
        display(login);
    }

    private static void showSignup() {
        SignupForm signup = new SignupForm();
        replaceButton(signup, "signUpButton", () -> {
            String name = field(signup, "nameField", JTextField.class).getText().trim();
            String email = field(signup, "emailField", JTextField.class).getText().trim();
            String phone = field(signup, "phoneField", JTextField.class).getText().trim();
            String username = field(signup, "usernameField", JTextField.class).getText().trim();
            char[] password = field(signup, "passwordField", JPasswordField.class).getPassword();
            try {
                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() ||
                        username.isEmpty() || password.length == 0) {
                    warn("Please complete every signup field.");
                    return;
                }
                if (LocalAccounts.exists(username)) {
                    warn("That username is already taken. Please choose another.");
                    return;
                }
                LocalAccounts.register(username, password, name, email, phone);
                signedInUser = username;
                JOptionPane.showMessageDialog(signup,
                        "Account created on this computer! Choose your membership plan.");
                showTrainerOption();
            } catch (IOException | GeneralSecurityException ex) {
                error("Could not save your account", ex);
            } finally {
                Arrays.fill(password, '\0');
            }
        });
        display(signup);
    }

    private static void showDashboard() {
        Dashboard dashboard = new Dashboard();
        JPanel panel = field(dashboard, "panelMain", JPanel.class);
        JFrame window = windowFor("Dashboard", panel, 500, 600);
        replaceButton(dashboard, "seeMembershipPlanButton", GymApp::showTrainerOption);
        replaceButton(dashboard, "logoutButton", () -> {
            signedInUser = "";
            selectedPlan = "";
            selectedTrainer = "";
            showWelcome();
        });
        replaceButton(dashboard, "updateProfileButton", () ->
                JOptionPane.showMessageDialog(window,
                        "The project has no edit-profile screen yet. " +
                                "This button is reserved for that future feature.",
                        "Not yet implemented", JOptionPane.INFORMATION_MESSAGE));
        display(window);
    }

    private static void showTrainerOption() {
        MembershipPlan1st option = new MembershipPlan1st();
        replaceButton(option, "withTrainerButton", () -> {
            wantsTrainer = true;
            showPlanDuration();
        });
        replaceButton(option, "withoutTrainerButton", () -> {
            wantsTrainer = false;
            selectedTrainer = "";
            showPlanDuration();
        });
        display(option);
    }

    private static void showPlanDuration() {
        MembershipPlan2nd duration = new MembershipPlan2nd();
        replaceButton(duration, "monthlyPassButton", () -> choosePlan("Monthly Pass"));
        replaceButton(duration, "quarterlyPassButton", () -> choosePlan("Quarterly Pass"));
        replaceButton(duration, "yearlyPassButton", () -> choosePlan("Yearly Pass"));
        display(duration);
    }

    private static void choosePlan(String plan) {
        selectedPlan = plan;
        // MembershipPlanPage has no bound root field in the uploaded .form,
        // so it may be unavailable as a standalone panel. Use it if possible.
        if (!showMembershipPlanPageIfAvailable()) {
            continueAfterPlan();
        }
    }

    private static boolean showMembershipPlanPageIfAvailable() {
        MembershipPlanPage preferences = new MembershipPlanPage();
        JComponent root = tryGetDesignerRoot(preferences);
        JButton proceed = fieldOrNull(preferences, "proceedButton", JButton.class);
        if (root == null || proceed == null) {
            System.out.println("MembershipPlanPage cannot be opened: no accessible GUI Designer root. " +
                    "Continuing to trainer/payment. See README.");
            return false;
        }
        JFrame window = windowFor("Membership Preferences", root, 500, 600);
        replaceButton(preferences, "proceedButton", GymApp::continueAfterPlan);
        display(window);
        return true;
    }

    private static void continueAfterPlan() {
        if (wantsTrainer) {
            showTrainerChooser();
        } else {
            showPayment();
        }
    }

    private static void showTrainerChooser() {
        ChooseYourTrainer picker = new ChooseYourTrainer();
        // Rebind the existing trainer panels, without changing ChooseYourTrainer.java.
        rebindPanelClicks(field(picker, "Trainer1", JPanel.class), "Jarvis");
        rebindPanelClicks(field(picker, "Trainer2", JPanel.class), "Harvey");
        rebindPanelClicks(field(picker, "Trainer3", JPanel.class), "Papart");
        display(picker);
    }

    private static void rebindPanelClicks(Component component, String trainerName) {
        for (MouseListener listener : component.getMouseListeners()) {
            component.removeMouseListener(listener);
        }
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                safely(() -> showTrainerProfile(trainerName));
            }
        });
        component.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                rebindPanelClicks(child, trainerName);
            }
        }
    }

    private static void showTrainerProfile(String trainerName) {
        TrainerProfile profile = new TrainerProfile(trainerName);
        JFrame window = windowFor("Trainer Profile - " + trainerName, profile.getPanel(), 500, 450);
        replaceButton(profile, "selectButton", () -> {
            int answer = JOptionPane.showConfirmDialog(window,
                    "Do you want to select " + trainerName + " as your trainer?",
                    "Confirm Trainer", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                selectedTrainer = trainerName;
                JOptionPane.showMessageDialog(window, trainerName + " has been selected!");
                showPayment();
            }
        });
        display(window);
    }

    private static void showPayment() {
        // The uploaded ZIP does not contain this required resource.
        if (GymApp.class.getResource("/images/QR_Code_Example.png") == null) {
            warn("Cannot open PaymentForm because /images/QR_Code_Example.png is missing.\n" +
                    "Add that image to your project's resources first.\n" +
                    "This is a demonstration form, not a real payment processor.");
            return;
        }
        PaymentForm payment = new PaymentForm();
        replaceButton(payment, "clickToPayButton", () -> {
            int answer = JOptionPane.showConfirmDialog(payment,
                    "Demo only: no real payment has been processed.\n" +
                            "Continue to the dashboard?",
                    "Demo payment", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                showDashboard();
            }
        });
        display(payment);
    }

    // --- Common navigation utilities: no existing Java classes are edited. ---

    private static void replaceButton(Object owner, String name, Runnable action) {
        JButton button = field(owner, name, JButton.class);
        for (ActionListener listener : button.getActionListeners()) {
            button.removeActionListener(listener);
        }
        button.addActionListener(e -> safely(action));
    }

    private static <T> T field(Object owner, String fieldName, Class<T> type) {
        try {
            Field f = owner.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            Object value = f.get(owner);
            if (value == null) {
                throw new IllegalStateException(owner.getClass().getSimpleName() + "." +
                        fieldName + " is null. Build the original .form files with IntelliJ GUI Designer.");
            }
            return type.cast(value);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            throw new IllegalStateException("Cannot find GUI field " + fieldName + " on " +
                    owner.getClass().getSimpleName(), ex);
        }
    }

    private static <T> T fieldOrNull(Object owner, String fieldName, Class<T> type) {
        try { return field(owner, fieldName, type); }
        catch (RuntimeException ex) { return null; }
    }

    private static JComponent tryGetDesignerRoot(Object screen) {
        try {
            Method m = screen.getClass().getMethod("$$$getRootComponent$$$");
            Object result = m.invoke(screen);
            return result instanceof JComponent ? (JComponent) result : null;
        } catch (ReflectiveOperationException ex) {
            return null;
        }
    }

    private static JFrame windowFor(String title, JComponent content, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        return frame;
    }

    private static void display(JFrame next) {
        JFrame previous = activeWindow;
        activeWindow = next;
        if (previous != null && previous != next) {
            previous.dispose();
        }
        next.setLocationRelativeTo(null);
        next.setVisible(true);
    }

    private static void warn(String message) {
        JOptionPane.showMessageDialog(activeWindow, message, "Notice", JOptionPane.WARNING_MESSAGE);
    }

    private static void error(String message, Exception ex) {
        JOptionPane.showMessageDialog(activeWindow,
                message + ":\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }

    private static void safely(Runnable action) {
        try {
            action.run();
        } catch (RuntimeException ex) {
            error("Navigation failed", ex);
        }
    }

    // Local-only demo account store. No database or internet service is used.
    // Passwords are salted and hashed, never saved as plain text.
    private static class LocalAccounts {
        private static final Path PATH = Paths.get(
                System.getProperty("user.home"), ".w-team-gym-demo", "accounts.properties");
        private static final SecureRandom RANDOM = new SecureRandom();
        private static final int ITERATIONS = 120_000;

        private static String key(String username) {
            return "account." + Base64.getUrlEncoder().withoutPadding()
                    .encodeToString(username.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        }

        private static Properties load() throws IOException {
            Properties data = new Properties();
            if (Files.exists(PATH)) {
                try (InputStream in = Files.newInputStream(PATH)) {
                    data.load(in);
                }
            }
            return data;
        }

        private static boolean exists(String username) throws IOException {
            return load().containsKey(key(username) + ".password");
        }

        private static void register(String username, char[] password, String name,
                                     String email, String phone)
                throws IOException, GeneralSecurityException {
            Properties data = load();
            String prefix = key(username);
            if (data.containsKey(prefix + ".password")) {
                throw new IOException("Username already exists.");
            }
            byte[] salt = new byte[16];
            RANDOM.nextBytes(salt);
            byte[] hash = hash(password, salt);
            data.setProperty(prefix + ".password",
                    Base64.getEncoder().encodeToString(salt) + ":" +
                            Base64.getEncoder().encodeToString(hash));
            data.setProperty(prefix + ".username", username);
            data.setProperty(prefix + ".name", name);
            data.setProperty(prefix + ".email", email);
            data.setProperty(prefix + ".phone", phone);
            Files.createDirectories(PATH.getParent());
            try (OutputStream out = Files.newOutputStream(PATH)) {
                data.store(out, "W-Team Gym demo accounts (local computer only)");
            }
            Arrays.fill(hash, (byte) 0);
        }

        private static boolean verify(String username, char[] password)
                throws IOException, GeneralSecurityException {
            String record = load().getProperty(key(username) + ".password");
            if (record == null) return false;
            String[] parts = record.split(":", 2);
            if (parts.length != 2) return false;
            byte[] salt = Base64.getDecoder().decode(parts[0]);
            byte[] expected = Base64.getDecoder().decode(parts[1]);
            byte[] actual = hash(password, salt);
            boolean matches = java.security.MessageDigest.isEqual(expected, actual);
            Arrays.fill(actual, (byte) 0);
            return matches;
        }

        private static byte[] hash(char[] password, byte[] salt) throws GeneralSecurityException {
            PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, 256);
            try {
                return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
                        .generateSecret(spec).getEncoded();
            } finally {
                spec.clearPassword();
            }
        }
    }
}
