package net.paintco.paint;

public class Pixel implements Drawable {
  private boolean hasCursor;
  private boolean isFilled;
  private String color = "";

  private static final String noColor = "\033[0m";

  public Pixel(boolean isFilled, String color) {
    this.isFilled = isFilled;
    this.hasCursor = false;
    this.color = color;
  }

  public Pixel(boolean isFilled) {
    this(isFilled, noColor);
  }

  public Pixel() {
    this(false);
  }

  @Override
  public String getString() {
    if (hasCursor) {
      if (isFilled) {
        // filled pixel with cursor
        return color + "▣" + noColor;
      } else {
        // unfilled pixel with cursor
        return color + "□" + noColor;
      }
    } else {
      if (isFilled) {
        // filled pixel without cursor
        return color + "█" + noColor;
      } else {
        // unfilled pixel without cursor
        return " ";
      }
    }
  }

  @Override
  public void setString(String string) {
    if (string.equals("▣")) {
      isFilled = true;
      hasCursor = true;
    } else if (string.equals("□")) {
      isFilled = false;
      hasCursor = true;
    } else if (string.equals("█")) {
      isFilled = false;
      hasCursor = false;
    } else if (string.equals(" ")) {
      isFilled = false;
      hasCursor = false;
    }
  }

  // Getters and Setters;
  public boolean hasCursor() {
    return hasCursor;
  }

  public void removeCursor() {
    hasCursor = false;
  }

  public void giveCursor() {
    hasCursor = true;
  }

  public boolean isFilled() {
    return isFilled;
  }

  public void fill() {
    isFilled = true;
  }

  public void empty() {
    isFilled = false;
  }

  @Override
  public void setColor(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  @Override
  public int getLength() {
    return 1;
  }
}
