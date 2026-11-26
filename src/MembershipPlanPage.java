import javax.swing.*;

public class MembershipPlanPage extends JFrame {
    private JRadioButton yogaRadioButton;
    private JRadioButton pilatesRadioButton;
    private JButton proceedButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JPanel panelMain;

    public MembershipPlanPage(boolean hasTrainer) {
        setTitle("Membership Plan");
        setContentPane(panelMain);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        proceedButton.addActionListener(e -> {

            if (hasTrainer) {
                new ChooseYourTrainer().setVisible(true);
            } else {
                new PaymentForm().setVisible(true);
            }

            dispose();
        });
    }


}
