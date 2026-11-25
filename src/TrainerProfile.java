
import javax.swing.*;

public class TrainerProfile {

    private JPanel panel1;
    private JButton selectButton;
    private JLabel descriptionLabel;
    private JLabel trainerNameLabel;

    private final String trainerName;

    public TrainerProfile() {
        this("Jarvis");
    }

    public TrainerProfile(String trainerName) {
        this.trainerName = trainerName;

        // Display the selected trainer's name
        trainerNameLabel.setText(trainerName);

        // Display the selected trainer's description
        descriptionLabel.setText(getDescription(trainerName));

        // Select button
        selectButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                    panel1,
                    "Do you want to select " + trainerName
                            + " as your trainer?",
                    "Confirm Trainer",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(
                        panel1,
                        trainerName
                                + " has been selected as your trainer!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    private String getDescription(String name) {

        if (name.equals("Jarvis")) {
            return "<html><div style='text-align: center;'>" +
                    "Hi! I'm Jarvis, a dedicated fitness trainer.<br>" +
                    "I specialize in strength training and<br>" +
                    "personalized workout programs.<br><br>" +
                    "My goal is to help you build confidence,<br>" +
                    "improve your fitness, and achieve your goals.<br>" +
                    "Let's work together toward a healthier you!" +
                    "</div></html>";
        }

        else if (name.equals("Harvey")) {
            return "<html><div style='text-align: center;'>" +
                    "Harvey's trainer biography goes here." +
                    "</div></html>";
        }

        else if (name.equals("Papart")) {
            return "<html><div style='text-align: center;'>" +
                    "Papart's trainer biography goes here." +
                    "</div></html>";
        }

        return "Trainer information not available.";
    }

    // Allows another class to display this GUI form
    public JPanel getPanel() {
        return panel1;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Trainer Profile - Jarvis");

            TrainerProfile profile = new TrainerProfile("Jarvis");

            frame.setContentPane(profile.getPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 450);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
