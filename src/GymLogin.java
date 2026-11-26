import javax.swing.*;
import java.awt.*;

public class GymLogin extends JFrame {

    private JTextField userName;
    private JPasswordField passwordField;
    private JButton logInButton;
    private JPanel panelMain;

    public GymLogin() {
        setTitle("Gym Login");
        setName("Gym Login");
        setContentPane(panelMain);
        panelMain.setPreferredSize(new Dimension(500, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        logInButton.addActionListener(e -> {

            String username = userName.getText().trim();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                new ErrorHandler(this).JOptionPaneError(
                        "Please enter both your username and password.");
                return;
            }

            // Admin login
            if (username.equals("admin")) {

                if (password.equals("YOUR_ADMIN_PASSWORD")) {
                    JOptionPane.showMessageDialog(this, "Welcome, Admin!");
                    new AdminProfile1st().setVisible(true);
                    dispose();
                } else {
                    new ErrorHandler(this).JOptionPaneError(
                            "Incorrect admin password.");
                }

                return;
            }

            // Regular user login
            UsersManager manager = new UsersManager();

            if (manager.login(username, password)) {

                JOptionPane.showMessageDialog(this,
                        "Welcome, " + username + "!");

                Dashboard dashboard = new Dashboard();

                JFrame frame = new JFrame("Dashboard");
                frame.setContentPane(dashboard.getPanelMain());
                frame.setSize(500, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                dispose();

            } else {
                new ErrorHandler(this).JOptionPaneError(
                        "Invalid username or password.");
            }
        });
    }
}