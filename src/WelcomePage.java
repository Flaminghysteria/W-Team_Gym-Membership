import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.*;

public class WelcomePage extends JFrame{
    private JButton logInButton;
    private JButton startYourFitnessJourneyButton;
    private JPanel panelMain;

    public WelcomePage(){
        setTitle("Welcome Page");
        setName("Welcome Page");
        setContentPane(panelMain);
        panelMain.setPreferredSize(new Dimension(500, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        logInButton.addActionListener(e -> {
            new GymLogin().setVisible(true);
            dispose(); // Closes WelcomePage while keeping GymLogin open
        });

        startYourFitnessJourneyButton.addActionListener(e -> {
            new SignupForm().setVisible(true);
            dispose();
        });
    }
}
