import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminProfile1st extends JFrame {
    private JPanel mainPanel;       // Set the root JPanel's "field name" to mainPanel in the .form
    private JLabel adminEmailLabel; // Optional: set field name in .form if you want to update it in code
    private JPanel membersPanel;
    private JLabel listOfMembersLabel;
    private JButton jayButton;
    private JButton brentButton;
    private JButton jarnickButton;

    public AdminProfile1st() {
        // Attach the GUI designer panel to this JFrame!
        setContentPane(mainPanel);
        setTitle("Admin Profile");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Button actions so you can test clicking each member
        jayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "Selected member: Jay");
            }
        });

        brentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "Selected member: Brent");
            }
        });

        jarnickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "Selected member: Jarnick");
            }
        });
    }
}
