import javax.swing.*;

public class ErrorHandler{
    private JFrame frame;
    public ErrorHandler(JFrame frame){
        this.frame=frame;
    }
    public void JOptionPaneError(String message){
        JOptionPane.showMessageDialog(
                frame,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
