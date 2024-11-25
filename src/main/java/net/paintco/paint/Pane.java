package net.paintco.paint;

public class Pane implements Drawable{
  Drawable[][] content;
  private int width;
  private int height;

  public Pane(int width, int height) {
    this.width = width;
    this.height = height;
    content = new Drawable[width][height]();
  }

  @Override
  public String getString() {
    String[][] strings = new String[width][height]();
    for (int i = 0; i < height; i++) {
      Drawable[] col = content[i];
      String row = "";
      for (Drawable element : col) {
        row += element.getString();
      }
      strings[i] = row;
    }

    return Utils.makeBox(content);
  }

  @Override
  public void setString(String string) {
    
  }
}
