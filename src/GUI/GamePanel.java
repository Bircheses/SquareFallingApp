package GUI;

import CONTENTS.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements MouseListener{
    int clicked_x,clicked_y,released_x,released_y;
    BufferedImage buffer;
    ArrayList<Square> squares;

    GamePanel(){
        initialize();
        squares=new ArrayList<>();
    }

    private void initialize(){
        setPreferredSize(new Dimension(1100,600));

        buffer = new BufferedImage(1100,600,BufferedImage.TYPE_INT_RGB);

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(CreateImageBuffer(),0,0,null);
    }

    private BufferedImage CreateImageBuffer(){
        Graphics2D g2d = buffer.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);//Setting Color of a Background
        g2d.fillRect(0, 0, 1100, 600);

        for (Square square : squares) {
            square.draw(g2d);
        }
        repaint();
        g2d.dispose();
        return buffer;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        clicked_x=e.getX();
        clicked_y=e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        released_x=e.getX();
        released_y=e.getY();

        Square square = new Square(clicked_x,clicked_y,released_x,released_y,squares);
        Thread thread = new Thread(square);
        thread.start();
        squares.add(square);

        System.out.println(Thread.activeCount());
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
