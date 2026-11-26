import javax.swing.*;
import java.awt.*;

public class MembershipPlan1st extends JFrame {

    private JLabel promptLabel;
    private JButton withTrainerButton;
    private JButton withoutTrainerButton;

    public MembershipPlan1st() {
        setTitle("Membership Plan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(580, 480);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        promptLabel = new JLabel("Choose your membership plan");
        promptLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 6));
        withTrainerButton = new JButton("With Trainer");
        withoutTrainerButton = new JButton("Without Trainer");

        buttonPanel.add(withTrainerButton);
        buttonPanel.add(withoutTrainerButton);

        add(promptLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        withTrainerButton.addActionListener(e -> {
            new MembershipPlan2nd(true).setVisible(true);
            dispose();
        });

        withoutTrainerButton.addActionListener(e -> {
            new MembershipPlan2nd(false).setVisible(true);
            dispose();
        });
    }


}