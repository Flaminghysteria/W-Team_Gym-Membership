import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ChooseYourTrainer extends JFrame {

    private JLabel Icon2;
    private JLabel Icon1;
    private JLabel Icon3;
    private JPanel panelMain;
    private JPanel Trainer1;
    private JPanel Trainer2;
    private JPanel Trainer3;

    public ChooseYourTrainer(){
        setTitle("Gym Login");
        setName("Gym Login");
        setContentPane(panelMain);
        panelMain.setPreferredSize(new Dimension(500, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        Icon1.setIcon(resizeIcon(Icon1.getIcon(), Icon1.getWidth(), Icon1.getHeight()));
        Icon2.setIcon(resizeIcon(Icon2.getIcon(), Icon2.getWidth(), Icon2.getHeight()));
        Icon3.setIcon(resizeIcon(Icon3.getIcon(), Icon3.getWidth(), Icon3.getHeight()));
        Trainer1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // code
            }
        });
        Trainer2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Your action code goes here
            }
        });
        Trainer3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Your action code goes her
            }
        });


    }

    private javax.swing.ImageIcon resizeIcon(javax.swing.Icon icon, int width, int height) {
        java.awt.Image img = ((javax.swing.ImageIcon) icon).getImage();
        java.awt.Image resizedImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new javax.swing.ImageIcon(resizedImg);
    }
}
