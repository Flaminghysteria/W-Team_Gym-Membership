
import javax.swing.*;

public class TrainerProfile {

    private JPanel panel1;
    private JButton selectButton;

    public TrainerProfile() {

        selectButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                    panel1,
                    "Do you want to select Jarvis as your trainer?",
                    "Confirm Trainer",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(
                        panel1,
                        "Jarvis has been selected as your trainer!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Trainer Profile - Jarvis");

        TrainerProfile profile = new TrainerProfile();

        frame.setContentPane(profile.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
