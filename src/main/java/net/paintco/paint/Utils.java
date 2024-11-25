package net.paintco.paint;

public class Utils {

  public static String makeBox(String input) {
    String[] array = { input };
    return makeBox(array);
  }

  public static String makeBox(String[] inputs) {
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
