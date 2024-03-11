package GUI;

import javax.swing.*;

/**
 * An initialization of main frame for an application
 */
public class MainFrame extends JFrame {
    MainFrame(String title){
        super(title);
        initialize();
    }
    private void initialize(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new GamePanel());
        pack();
        setLocationRelativeTo(null);
    }
    public static void main(String[] Args){
        SwingUtilities.invokeLater(() -> new MainFrame("Kolokwium").setVisible(true));
    }
}
