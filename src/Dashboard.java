import javax.swing.*;

public class Dashboard extends JFrame {
    private JPanel panelMain;
    private JButton seeMembershipPlanButton;
    private JButton updateProfileButton;
    private JButton logoutButton;

    public Dashboard() {

        setContentPane(panelMain);
        setTitle("Dashboard");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        logoutButton.addActionListener(e -> {
            new WelcomePage().setVisible(true);
            dispose();
        });

        seeMembershipPlanButton.addActionListener(e -> {
            new MembershipPlan1st().setVisible(true);
            dispose();
        });
    }
}