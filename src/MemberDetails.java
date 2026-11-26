import javax.swing.*;

public class MemberDetails {
    private JPanel detailsPanel;
    private JLabel memberNameLabel;
    private JTextField quarterlyPlanWTrainerTextField;
    private JTextField dueDateField;
    private JButton viewPaymentHistoryButton;

    public MemberDetails(String memberName, String plan, String dueDate) {
        if (memberNameLabel != null && memberName != null) {
            memberNameLabel.setText(memberName);
        }
        if (quarterlyPlanWTrainerTextField != null && plan != null) {
            quarterlyPlanWTrainerTextField.setText(plan);
        }
        if (dueDateField != null && dueDate != null) {
            dueDateField.setText(dueDate);
        }

        if (viewPaymentHistoryButton != null) {
            viewPaymentHistoryButton.addActionListener(e ->
                    JOptionPane.showMessageDialog(
                            detailsPanel,
                            "Viewing payment history for " + (memberName != null ? memberName : "Member")
                    )
            );
        }
    }

    public JPanel getDetailsPanel() {
        return detailsPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Member Details Test");
            MemberDetails view = new MemberDetails(
                    "Jay",
                    "Quarterly Plan w/ Trainer",
                    "due November 28, 2026"
            );
            frame.setContentPane(view.getDetailsPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(380, 450);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}