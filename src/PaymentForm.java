import javax.swing.*;
import java.awt.*;

public class PaymentForm extends JFrame{
    private JPanel panelMain;
    private JButton clickToPayButton;
    private JPanel qrCode;

    public PaymentForm(){
        setTitle("Payment");
        setContentPane(panelMain);
        panelMain.setPreferredSize(new Dimension(500, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon rawIcon = new ImageIcon(getClass().getResource("/images/QR_Code_Example.png"));
        Image scaledImage = rawIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel qrLabel = new JLabel(new ImageIcon(scaledImage));

        qrCode.setLayout(new BorderLayout());
        qrCode.add(qrLabel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);

        clickToPayButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    this,
                    "Payment confirmed!",
                    "Payment Successful",
                    JOptionPane.INFORMATION_MESSAGE
            );
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PaymentForm().setVisible(true);
        });
    }
}
