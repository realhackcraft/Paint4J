package net.paintco.paint;

public class Toolbox extends Pane {
  private StringWrapper[] labels;
  private int selected = 0;

  public Toolbox(StringWrapper[] string) {
    // We don't need width and height, the makeBox code is different
    super(0, 0);
    this.labels = string;
  }

  private String makeBox(String[] labels, int[] lengths) {
    String out = "";

    for (int i = 0; i < labels.length; i++) {
      int length = lengths[i];

      if (selected == i) {
        out += "┌";
      } else {
        out += " ";
      }

      for (int j = 0; j < length - 2; j++) {
        if (selected == i) {
          out += "─";
        } else {
          out += " ";
        }
      }

      if (selected == i) {
        out += "┐";
      } else {
        out += " ";
      }
    }
    out += "\n";

    for (int i = 0; i < labels.length; i++) {
      if (selected == i) {
        out += "│";
      } else {
        out += " ";
      }
      out += labels[i];
      if (selected == i) {
        out += "│";
      } else {
        out += " ";
      }
    }
    out += "\n";

    for (int i = 0; i < labels.length; i++) {
      int length = lengths[i];

      if (selected == i) {
        out += "└";
      } else {
        out += " ";
      }

      for (int j = 0; j < length - 2; j++) {
        if (selected == i) {
          out += "─";
        } else {
          out += " ";
        }
      }

      if (selected == i) {
        out += "┘";
      } else {
        out += " ";
      }
    }
    return out;
  }

  public void setString(StringWrapper string, int index) {
    labels[index] = string;
  }

  public int getSelected() {
    return selected;
  }

  public void setSelected(int index) {
    if (index < labels.length) {
      selected = index;
    }
  }

  @Override
  public String getString() {
    String[] stringLabels = new String[labels.length];
    int[] lengths = new int[labels.length];

    for (int i = 0; i < labels.length; i++) {
      stringLabels[i] = labels[i].getString();
      lengths[i] = labels[i].getLength();
    }
    return makeBox(stringLabels, lengths);
  }

  @Override
  public void setDrawable(int x, int y, Drawable drawable) {
  }

  public void move(int amount) {
    selected += amount;
    selected = Math.max(selected, 0);
    selected = Math.min(labels.length, selected);
  }
}
