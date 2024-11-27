package net.paintco.paint;

public class StringWrapper implements Drawable {
  protected String string;
  protected String color = "";
  protected static final String noColor = "\033[0m";

  public StringWrapper(String string, String color) {
    this.string = string;
    this.color = color;
  }

  public StringWrapper(String string) {
    this(string, "");
  }

  public StringWrapper(char aChar) {
    this.string = Character.toString(aChar);
  }

  @Override
  public String getString() {
    return this.color + this.string + noColor;
  }

  @Override
  public void setString(String string) {
    this.string = string;
  }

  @Override
  public int getLength() {
    return string.length();
  }

  @Override
  public String getColor() {
    return this.color;
  }

  @Override
  public void setColor(String color) {
    this.color = color;
  }
}
