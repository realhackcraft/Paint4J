package net.paintco.paint;

public class Pane implements Drawable {
  Drawable[][] content;
  private int width;
  private int height;

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
    String[] strings = new String[height];
    for (int i = 0; i < content.length; i++) {
      Drawable[] col = content[i];
      String row = "";
      for (Drawable element : col) {
        row += element.getString();
      }
      strings[i] = row;
    }

    return makeBox(strings);
  }

  public void setDrawable(int x, int y, Drawable drawable) {
    content[x][y] = drawable;
  }

  @Override
  public void setString(String string) {
  }

  private String makeBox(String[] inputs) {
    String out = "┌";
    int max = 0;
    for (int i = 0; i < inputs.length; i++) {
      if (inputs[i].length() > max)
        max = inputs[i].length();
    }

    for (int i = 0; i < max; i++) {
      out += "─";
    }
    out += "┐\n";
    for (String input : inputs) {
      int filler = max - input.length();
      out += "│" + input;
      for (int i = 0; i < filler; i++) {
        out += " ";
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
}
