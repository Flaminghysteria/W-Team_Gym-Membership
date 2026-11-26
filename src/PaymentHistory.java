import javax.swing.*;

public class PaymentHistory {
    private JPanel historyPanel; // Set root JPanel's "field name" in PaymentHistory.form to historyPanel
    private JLabel memberNameLabel; // Optional: set "field name" in .form if you want to update it dynamically
    private JLabel titleLabel;      // Optional: set "field name" in .form if you want to update it dynamically
    private JLabel payment1;
    private JLabel payment2;

    public PaymentHistory(String memberName, String firstPayment, String secondPayment) {
        if (memberNameLabel != null && memberName != null) {
            memberNameLabel.setText(memberName);
        }
        if (payment1 != null && firstPayment != null) {
            payment1.setText(firstPayment);
        }
        if (payment2 != null && secondPayment != null) {
            payment2.setText(secondPayment);
        }
    }

    public JPanel getHistoryPanel() {
        return historyPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Payment History Test");
            PaymentHistory view = new PaymentHistory(
                    "Jay",
                    "₱ 2,985..........November 8, 2026",
                    "₱ 2,985..........November 18, 2026"
            );
            frame.setContentPane(view.getHistoryPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(380, 450);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}