import javax.swing.*;
import java.awt.*;

public class GymLogin extends JFrame{
    private JTextField userName;
    private JPasswordField passwordField;
    private JButton logInButton;
    private JPanel panelMain;

    public GymLogin(){
        setTitle("Gym Login");
        setName("Gym Login");
        setContentPane(panelMain);
        panelMain.setPreferredSize(new Dimension(500, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        logInButton.addActionListener(e -> {
            String username = userName.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter both your username and password.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Proceed with login verification and redirect to Dashboard
            JOptionPane.showMessageDialog(
                    this,
                    "Login successful!",
                    "Welcome",
                    JOptionPane.INFORMATION_MESSAGE
            );
            dispose();
        });
    }
}
