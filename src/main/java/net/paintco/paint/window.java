package net.paintco.paint;

import java.util.Scanner

public class Window extends Pane{
    private int cursorX, int cursorY;

    public Window(){
        cursorX=0;
        cursorY=0;
    }

    public move_x(int step){
        cursorX+=step;
        cursorX=Math.max(0, cursorX);
        cursorX=Math.min(width, cursorX);
    }

    public void move_y(int step){
        cursorY+=step;
        cursorY=Math.max(0, cursorY);
        cursorY=Math.min(height, cursorY);
    }

    @Override
    public void setDrawable(int x, int y, Drawable drawable) {}

    public void setPixel(int x, int y, Pixel p){
        content[y][x]=p;
    }
}