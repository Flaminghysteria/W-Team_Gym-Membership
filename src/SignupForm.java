import javax.swing.*;
import java.awt.*;

public class SignupForm extends JFrame {

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel panelMain;
    private JButton signUpButton;
    private JTextField emailField;

    public SignupForm() {
        setTitle("Sign Up");
        setContentPane(panelMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelMain.setPreferredSize(new Dimension(500, 600));
        pack();
        setLocationRelativeTo(null);

        signUpButton.addActionListener(e -> {

            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (name.isEmpty() || email.isEmpty() ||
                    phone.isEmpty() || username.isEmpty() ||
                    password.isEmpty()) {

                new ErrorHandler(this).JOptionPaneError(
                        "Please complete every signup field.");
                return;
            }

            if (username.equalsIgnoreCase("admin")) {
                new ErrorHandler(this).JOptionPaneError(
                        "This username is reserved.");
                return;
            }

            if (FileHandler.findUser(name, email, phone, username)) {
                new ErrorHandler(this).JOptionPaneError(
                        "Account information already exists.");
                return;
            }

            UsersManager manager = new UsersManager();

            if (manager.signup(name, email, phone, username, password)) {

                JOptionPane.showMessageDialog(this,
                        "Account created successfully!");

                new MembershipPlan1st().setVisible(true);
                dispose();

            } else {
                new ErrorHandler(this).JOptionPaneError(
                        "Unable to create account.");
            }
        });
    }
}