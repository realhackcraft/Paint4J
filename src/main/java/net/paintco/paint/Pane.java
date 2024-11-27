package net.paintco.paint;

public class Pane implements Drawable {
  protected Drawable[][] content;
  protected int width;
  protected int height;

  public Pane(int width, int height) {
    this.width = width;
    this.height = height;
    content = new Drawable[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        content[i][j] = new NotDrawable();
      }
    }
  }

  public Pane(String[] string) {
    int max = 0;
    for (int i = 0; i < string.length; i++) {
      String oneString = string[i];
      if (oneString.length() > max) {
        max = oneString.length();
      }
    }

    this.width = max;
    this.height = string.length;
    content = new Drawable[height][width];
    for (int i = 0; i < height; i++) {
      String oneString = string[i];
      for (int j = 0; j < width; j++) {
        if (oneString.length() > j) {
          content[i][j] = new StringWrapper(oneString.charAt(j));
        } else {
          content[i][j] = new NotDrawable();
        }
      }
    }
  }

  @Override
  public String getString() {
    return makeBox(content);
  }

  public void setDrawable(int x, int y, Drawable drawable) {
    content[y][x] = drawable;
  }

  @Override
  public void setString(String string) {
  }

  private String makeBox(Drawable[][] inputs) {
    String out = "┌";
    int max = inputs[0].length;

    for (int i = 0; i < max; i++) {
      out += "─";
    }
    out += "┐\n";
    for (Drawable[] row : inputs) {
      out += "│";
      for (Drawable input : row) {
        out += input.getString();
      }
      out += "│\n";
    }

    out += "└";
    for (int i = 0; i < max; i++) {
      out += "─";
    }
    out += "┘";
    return out;
  }

  @Override
  public int getLength() {
    return -1;
  }

  @Override
  public String getColor() {
    return "";
  }

  @Override
  public void setColor(String color) {
  }
}
