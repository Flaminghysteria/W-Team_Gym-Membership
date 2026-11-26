import javax.swing.SwingUtilities;

public class GymApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WelcomePage().setVisible(true);
        });
    }
}