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

            if (username.equals("admin")) {
                Admin admin = new Admin();
                if (password.equals(admin.getPassword())) {
                    JOptionPane.showMessageDialog(this, "Welcome, Admin!");
                    new AdminProfile1st().setVisible(true);
                    dispose();
                } else {
                    new ErrorHandler(this).JOptionPaneError(
                            "Incorrect admin password.");
                }

                return;
            }


            UsersManager manager = new UsersManager();

            if (manager.login(username, password)) {

                JOptionPane.showMessageDialog(this,
                        "Welcome, " + username + "!");

                new Dashboard().setVisible(true);
                dispose();

            } else {
                new ErrorHandler(this).JOptionPaneError(
                        "Invalid username or password.");
            }
        });
    }
}