import javax.swing.*;

public class TrainerDetails {
    private JPanel trainerDetailsPanel; // Set root JPanel's "field name" in TrainerDetails.form to trainerDetailsPanel
    private JLabel trainerNameLabel;    // Optional: set "field name" in .form to match
    private JLabel specialtyLabel;      // Optional: set "field name" in .form to match
    private JLabel ageGenderLabel;      // Optional: set "field name" in .form to match

    public TrainerDetails(String trainerName, String specialty, String ageAndGender) {
        if (trainerNameLabel != null && trainerName != null) {
            trainerNameLabel.setText(trainerName);
        }
        if (specialtyLabel != null && specialty != null) {
            specialtyLabel.setText(specialty);
        }
        if (ageGenderLabel != null && ageAndGender != null) {
            ageGenderLabel.setText(ageAndGender);
        }
    }

    public JPanel getTrainerDetailsPanel() {
        return trainerDetailsPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Trainer Details Test");
            TrainerDetails view = new TrainerDetails(
                    "Jarvis",
                    "Strength and Conditioning",
                    "37, Male"
            );
            frame.setContentPane(view.getTrainerDetailsPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(380, 450);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}