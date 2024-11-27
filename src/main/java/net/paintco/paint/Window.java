package net.paintco.paint;

public class Window extends Pane{
    private int cursorX, int cursorY;

    public Window(){
        cursorX=0;
        cursorY=0;
    }

    public moveX(int step){
        cursorX+=step;
        cursorX=Math.max(0, cursorX);
        cursorX=Math.min(width, cursorX);
    }

    public void moveY(int step){
        cursorY+=step;
        cursorY=Math.max(0, cursorY);
        cursorY=Math.min(height, cursorY);
    }

    @Override
    public void setDrawable(int x, int y, Drawable drawable) {}

    public void setPixel(Pixel p){
        content[cursorY][cursorX]=p;
    }
}