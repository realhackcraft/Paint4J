package net.paintco.paint;

public class Window extends Pane {
  private int cursorX, cursorY;

  public Window(int x, int y) {
    super(x, y);
    cursorX = 0;
    cursorY = 0;
    content = new Drawable[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        content[i][j] = new Pixel();
      }
    }
    Pixel pixel = (Pixel) content[0][0];
    pixel.giveCursor();
  }

  public void moveX(int step) {
    Pixel pixel = (Pixel) (content[cursorY][cursorX]);
    pixel.removeCursor();

    cursorX += step;
    cursorX = Math.max(0, cursorX);
    cursorX = Math.min(width - 1, cursorX);

    Pixel newPixel = (Pixel) (content[cursorY][cursorX]);
    newPixel.giveCursor();
  }

  public void moveY(int step) {
    Pixel pixel = (Pixel) (content[cursorY][cursorX]);
    pixel.removeCursor();

    cursorY += step;
    cursorY = Math.max(0, cursorY);
    cursorY = Math.min(height - 1, cursorY);

    Pixel newPixel = (Pixel) (content[cursorY][cursorX]);
    newPixel.giveCursor();
  }

  @Override
  public void setDrawable(int x, int y, Drawable drawable) {
  }

  public void setPixel(Pixel p) {
    p.giveCursor();
    content[cursorY][cursorX] = p;
  }
}
