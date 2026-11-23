
import javax.swing.*;

public class TrainerProfile {

    private JPanel panel1;
    private JButton selectButton;
    private JLabel descriptionLabel;

    public TrainerProfile() {


        descriptionLabel.setText(
                "<html><div style='text-align: center;'>" +
                        "Hi! I'm Jarvis, a dedicated fitness trainer.<br>" +
                        "I specialize in strength training and<br>" +
                        "personalized workout programs.<br><br>" +
                        "My goal is to help you build confidence,<br>" +
                        "improve your fitness, and achieve your goals.<br>" +
                        "Let's work together toward a healthier you!" +
                        "</div></html>"
        );

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
