import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MembershipPlan2nd extends JFrame {
    private JPanel panel1;
    private JButton monthlyPassButton;
    private JButton quarterlyPassButton;
    private JButton yearlyPassButton;
    private JLabel titleLabel;
    private boolean hasTrainer;

    public MembershipPlan2nd(boolean hasTrainer) {
        this.hasTrainer = hasTrainer;
        setTitle("Membership Plan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 320);
        setLocationRelativeTo(null);

        initComponents();
        initListeners();

        setContentPane(panel1);
    }

    private void initComponents() {
        panel1 = new JPanel(new BorderLayout(10, 10));
        panel1.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        titleLabel = new JLabel("Choose Your Membership Plan", SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 16f));

        JPanel optionsPanel = new JPanel(new GridLayout(3, 1, 0, 12));
        monthlyPassButton = new JButton("Monthly Pass");
        quarterlyPassButton = new JButton("Quarterly Pass");
        yearlyPassButton = new JButton("Yearly Pass");

        optionsPanel.add(monthlyPassButton);
        optionsPanel.add(quarterlyPassButton);
        optionsPanel.add(yearlyPassButton);

        panel1.add(titleLabel, BorderLayout.NORTH);
        panel1.add(optionsPanel, BorderLayout.CENTER);
    }

    private void initListeners() {
        monthlyPassButton.addActionListener((ActionEvent e) -> handleSelection("Monthly Pass"));
        quarterlyPassButton.addActionListener((ActionEvent e) -> handleSelection("Quarterly Pass"));
        yearlyPassButton.addActionListener((ActionEvent e) -> handleSelection("Yearly Pass"));
    }

    private void handleSelection(String planName) {
        JOptionPane.showMessageDialog(
                this,
                "Selected plan: " + planName,
                "Membership Selection",
                JOptionPane.INFORMATION_MESSAGE
        );
        // TODO: Connect to MembershipPlan / Dashboard / Signup flow as needed
        new MembershipPlanPage(hasTrainer).setVisible(true);
        dispose();
    }


}
