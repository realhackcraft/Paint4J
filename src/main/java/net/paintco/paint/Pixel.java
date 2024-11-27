package net.paintco.paint;

public class Pixel implements Drawable {
  private boolean hasCursor;
  private boolean isFilled;

  public Pixel(boolean isFilled) {
    this.isFilled = isFilled;
    this.hasCursor = false;
  }

  public Pixel() {
    this(false);
  }

  @Override
  public String getString() {
    if (hasCursor) {
      if (isFilled) {
        // filled pixel with cursor
        return "▣";
      } else {
        // unfilled pixel with cursor
        return "□";
      }
    } else {
      if (isFilled) {
        // filled pixel without cursor
        return "█";
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
  public int getLength() {
    return -1;
  }
}
