package net.paintco.paint;

public class Toolbox extends Pane {
  private StringWrapper[] labels;
  private int selectedTool = 0;
  private int selectedColor = 2;

  public Toolbox(StringWrapper[] string) {
    // We don't need width and height, the makeBox code is different
    super(0, 0);
    this.labels = string;
  }

  private String makeBox(StringWrapper[] labels) {
    String out = "";

    int[] lengths = new int[labels.length];

    for (int i = 0; i < labels.length; i++) {
      lengths[i] = labels[i].getLength();
    }

    for (int i = 0; i < labels.length; i++) {
      int length = lengths[i];

      if (selectedTool == i || selectedColor == i) {
        out += "┌";
      } else {
        out += " ";
      }

      for (int j = 0; j < length; j++) {
        if (selectedTool == i || selectedColor == i) {
          out += "─";
        } else {
          out += " ";
        }
      }

      if (selectedTool == i || selectedColor == i) {
        out += "┐";
      } else {
        out += " ";
      }
    }
    out += "\n";

    for (int i = 0; i < labels.length; i++) {
      if (selectedTool == i || selectedColor == i) {
        out += "│";
      } else {
        out += " ";
      }
      out += labels[i].getString();
      if (selectedTool == i || selectedColor == i) {
        out += "│";
      } else {
        out += " ";
      }
    }
    out += "\n";

    for (int i = 0; i < labels.length; i++) {
      int length = lengths[i];

      if (selectedTool == i || selectedColor == i) {
        out += "└";
      } else {
        out += " ";
      }

      for (int j = 0; j < length; j++) {
        if (selectedTool == i || selectedColor == i) {
          out += "─";
        } else {
          out += " ";
        }
      }

      if (selectedTool == i || selectedColor == i) {
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

  public int getSelectedTool() {
    return selectedTool;
  }

  public int getSelectedColor() {
    return selectedColor;
  }

  public void setSelectedTool(int index) {
    if (index < labels.length) {
      selectedTool = index;
    }
  }

  @Override
  public String getString() {
    return makeBox(labels);
  }

  @Override
  public void setDrawable(int x, int y, Drawable drawable) {
  }

  public void move(int amount) {
    selectedTool += amount;
    selectedTool = Math.max(selectedTool, 0);
    selectedTool = Math.min(1, selectedTool);
  }

  public void selectColor(int num) {
    selectedColor = num;
    selectedColor = Math.max(selectedColor, 2);
    selectedColor = Math.min(labels.length - 1, selectedColor);
  }
}
