package CONTENTS;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class Square implements Runnable{
    int x,y,width,height,dy;
    ArrayList<Square> squares;
    Random random = new Random();
    Color color = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));

    public Square(int x_clicked, int y_clicked, int x_released, int y_released, ArrayList<Square> squares){
        this.squares=squares;
        if(x_released>x_clicked){
            x=x_clicked;
        }else if(x_clicked>x_released){
            x=x_released;
        }
        if(y_released>y_clicked){
            y=y_clicked;
        }else if(y_clicked>y_released){
            y=y_released;
        }
        width=abs(x_released-x_clicked);
        height=abs(y_released-y_clicked);
        dy=random.nextInt(5,10);
    }
    public void draw(Graphics2D g2d){
        g2d.setColor(color);
        g2d.fillRect(x,y,width,height);
    }

    private void CheckCollision(int WindowHeight){
        if(y>WindowHeight) y=-height;
        for (Square square:squares) {
            if(square!=this && dy!=0) {
                if(width>square.width && y>0 && square.y > 0)  {
                    if (y + height >= square.y && y + height <= square.y+square.height && square.x>=x && square.x<=x+width) {
                        dy = 0;
                    }
                }else{
                    if (y + height >= square.y && y + height <= square.y+square.height && x >= square.x && x <= square.x + square.width) {
                        dy = 0;
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        while(true){
            y+=dy;
            CheckCollision(600);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
