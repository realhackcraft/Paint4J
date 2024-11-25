package net.paintco.paint;

public class StringWrapper implements Drawable {
  private String string;

  public StringWrapper(String string) {
    this.string = string;
  }

  @Override
  public String getString() {
    return this.string;
  }

  @Override
  public void setString(String string) {
    this.string = string;
  }
}
