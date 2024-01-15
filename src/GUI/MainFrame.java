package GUI;

import javax.swing.*;

public class MainFrame extends JFrame {
    GamePanel gamePanel;

    MainFrame(String title){
        super(title);
        initialize();
    }

    private void initialize(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gamePanel = new GamePanel();
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] Args){
        SwingUtilities.invokeLater(() -> new MainFrame("Kolokwium").setVisible(true));
    }
}
