
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChooseYourTrainer extends JFrame{

    private JLabel Icon2;
    private JLabel Icon1;
    private JLabel Icon3;
    private JPanel panelMain;
    private JPanel Trainer1;
    private JPanel Trainer2;
    private JPanel Trainer3;

    public ChooseYourTrainer() {

        setTitle("Choose Your Trainer");
        setContentPane(panelMain);

        panelMain.setPreferredSize(new Dimension(500, 600));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setLocationRelativeTo(null);

        // Resize images after the GUI has been laid out
        SwingUtilities.invokeLater(() -> {
            resizeLabelIcon(Icon1);
            resizeLabelIcon(Icon2);
            resizeLabelIcon(Icon3);
        });

        // Make each trainer panel clickable
        makeClickable(Trainer1, "Jarvis");
        makeClickable(Trainer2, "Harvey");
        makeClickable(Trainer3, "Papart");
    }

    private void makeClickable(JPanel panel, String trainerName) {

        MouseAdapter listener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                openTrainerProfile(trainerName);
            }
        };

        addListenerToChildren(panel, listener);
    }

    // Also makes labels and icons inside a panel clickable
    private void addListenerToChildren(
            Component component,
            MouseAdapter listener) {

        component.addMouseListener(listener);

        component.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        if (component instanceof Container) {
            Container container = (Container) component;

            for (Component child : container.getComponents()) {
                addListenerToChildren(child, listener);
            }
        }
    }

    private void openTrainerProfile(String trainerName) {
        new TrainerProfile(trainerName).setVisible(true);
        dispose();
    }

    private void resizeLabelIcon(JLabel label) {

        if (label == null ||
                !(label.getIcon() instanceof ImageIcon)) {
            return;
        }

        int width = label.getWidth();
        int height = label.getHeight();

        if (width <= 0 || height <= 0) {
            return;
        }

        ImageIcon icon = (ImageIcon) label.getIcon();

        Image resizedImage = icon.getImage().getScaledInstance(
                width,
                height,
                Image.SCALE_SMOOTH
        );

        label.setIcon(new ImageIcon(resizedImage));
    }

}
