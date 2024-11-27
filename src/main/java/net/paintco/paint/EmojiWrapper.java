package net.paintco.paint;

public class EmojiWrapper extends StringWrapper {

  public EmojiWrapper(String string, String color) {
    super(string + " ", color);
  }

  public EmojiWrapper(String string) {
    super(string + " ");
  }

  public EmojiWrapper(char aChar) {
    super(aChar + " ");
  }

  @Override
  public int getLength() {
    return string.length() - 2;
  }
}
