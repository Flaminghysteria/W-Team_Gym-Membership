import javax.swing.*;

public class TrainerList {
    private JPanel trainerListPanel; // Set root JPanel's "field name" in TrainerList.form to trainerListPanel
    private JLabel adminEmailLabel;  // Optional: set "field name" in .form to match
    private JLabel listOfTrainersLabel; // Optional: set "field name" in .form to match
    private JButton jarvisButton;
    private JButton harveyButton;
    private JButton papartButton;

    public TrainerList() {
        if (jarvisButton != null) {
            jarvisButton.addActionListener(e ->
                    JOptionPane.showMessageDialog(trainerListPanel, "Selected trainer: Jarvis")
            );
        }
        if (harveyButton != null) {
            harveyButton.addActionListener(e ->
                    JOptionPane.showMessageDialog(trainerListPanel, "Selected trainer: Harvey")
            );
        }
        if (papartButton != null) {
            papartButton.addActionListener(e ->
                    JOptionPane.showMessageDialog(trainerListPanel, "Selected trainer: Papart")
            );
        }
    }

    public JPanel getTrainerListPanel() {
        return trainerListPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("List of Trainers");
            TrainerList view = new TrainerList();
            frame.setContentPane(view.getTrainerListPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}