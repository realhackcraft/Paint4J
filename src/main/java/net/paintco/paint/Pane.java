package net.paintco.paint;

public class Pane implements Drawable {
  Drawable[][] content;
  private int width;
  private int height;

  public Pane(int width, int height) {
    this.width = width;
    this.height = height;
    content = new Drawable[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        content[i][j] = new NotDrawable();
      }
    }
  }

  @Override
  public String getString() {
    String[] strings = new String[width];
    for (int i = 0; i < width; i++) {
      Drawable[] col = content[i];
      System.out.println(i);
      String row = "";
      for (Drawable element : col) {
        row += element.getString();
      }
      strings[i] = row;
    }

    return Utils.makeBox(strings);
  }

  public void setDrawable(int x, int y, Drawable drawable) {
    content[y][x] = drawable;
  }

  @Override
  public void setString(String string) {
  }
}
