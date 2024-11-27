package net.paintco.paint;

public class NotDrawable implements Drawable {
  @Override
  public void setString(String string) {
  }

  @Override
  public int getLength() {
    return 1;
  }

  @Override
  public String getString() {
    return " ";
  }

  @Override
  public String getColor() {
    return "";
  }

  @Override
  public void setColor(String color) {
  }
}
