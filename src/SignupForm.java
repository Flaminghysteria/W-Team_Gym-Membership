import javax.swing.*;
import java.awt.*;

public class SignupForm extends JFrame{
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
            String field1 = nameField.getText().trim();
            String field2 = phoneField.getText().trim();
            String field3 = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (field1.isEmpty() || field2.isEmpty() || field3.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please fill in all fields before signing up.",
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }


            JOptionPane.showMessageDialog(
                    this,
                    "Account created successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
            new MembershipPlan1st().setVisible(true);
            dispose();
        });
    }

}
