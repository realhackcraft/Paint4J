package net.paintco.paint;

import java.util.Scanner;

/** Hello world! */
public class App {
  Scanner scanner = new Scanner(System.in);
  Window window;
  Toolbox toolbox;

  public static void main(String[] args) {
    App app = new App();
    app.initialize();
  }

  public void initialize() {
    clear();
    String[] welcomeString = { "Welcome to Paint©!" };
    Pane welcome = new Pane(welcomeString);
    System.out.println(welcome.getString());

    load();

    String[] doneString = { "Done!", "Enjoy using Paint©!" };
    Pane done = new Pane(doneString);
    System.out.println(done.getString());
    try {
      Thread.sleep(1000);
    } catch (Exception e) {

    }
    run();
  }

  public void run() {
    clear();
    window = new Window(80, 24);
    StringWrapper[] labels = {
        new EmojiWrapper("🖌️"),
        new EmojiWrapper("🗑️"),
        new StringWrapper("▩"),
        new StringWrapper("▩", "\033[0;31m"),
        new StringWrapper("▩", "\033[0;32m"),
        new StringWrapper("▩", "\033[0;33m"),
        new StringWrapper("▩", "\033[0;34m"),
        new StringWrapper("▩", "\033[0;35m"),
        new StringWrapper("▩", "\033[0;36m"),
        new StringWrapper("▩", "\033[0;37m"),
    };
    toolbox = new Toolbox(labels);
    Pixel[][] pixels = new Pixel[80][24];
    for (int i = 0; i < pixels.length; i++) {
      Pixel[] row = pixels[i];
      for (int j = 0; j < row.length; j++) {
        pixels[i][j] = new Pixel();
      }
    }

    String lastCommand = "";
    while (true) {
      lastCommand = loop(lastCommand);
    }
  }

  public String loop(String lastCommand) {
    clear();
    System.out.println(window.getString());
    System.out.println(toolbox.getString());
    String command = input();
    command = command.toLowerCase();

    if (command.equals("")) {
      command = lastCommand;
    }

    for (int i = 0; i < command.length(); i++) {
      char currentCommand = command.charAt(i);
      switch (currentCommand) {
        case 'a':
          window.moveX(-1);
          break;
        case 'd':
          window.moveX(1);
          break;
        case 'w':
          window.moveY(-1);
          break;
        case 's':
          window.moveY(1);
          break;
        case ',':
          toolbox.move(-1);
          break;
        case '.':
          toolbox.move(1);
          break;
        case '1':
          toolbox.selectColor(2);
          break;
        case '2':
          toolbox.selectColor(3);
          break;
        case '3':
          toolbox.selectColor(4);
          break;
        case '4':
          toolbox.selectColor(5);
          break;
        case '5':
          toolbox.selectColor(6);
          break;
        case '6':
          toolbox.selectColor(7);
          break;
        case '7':
          toolbox.selectColor(8);
          break;
        case ' ':
          draw();
          break;
        default:
          break;
      }
    }

    return command.toLowerCase();
  }

  public void draw() {
    int selectedTool = toolbox.getSelectedTool();
    int selectedColor = toolbox.getSelectedColor();
    switch (selectedTool) {
      case 0:
        window.setPixel(
            new Pixel(true, "\033[0;" + (28 + (selectedColor == 2 ? -28 : selectedColor)) + "m"));
        break;
      case 1:
        window.setPixel(new Pixel(false));
        break;
      default:
        break;
    }
  }

  public String input() {
    System.out.print("Use WASD to move cursor; use , and . to change tool, 1-7 to change color: ");
    return scanner.nextLine();
  }

  public void clear() {
    System.out.println("\033[H");
    System.out.println("\033[J");
  }

  public void load() {
    try {
      Pane loader = new Pane(1, 1);
      Thread.sleep(1000);
      clear();
      int duration = 100;
      for (int i = 0; i < 5; i++) {
        loader.setDrawable(0, 0, new StringWrapper("⠋"));
        System.out.println(loader.getString());
        Thread.sleep(duration);
        clear();
        loader.setDrawable(0, 0, new StringWrapper("⠙"));
        System.out.println(loader.getString());
        Thread.sleep(duration);
        clear();
        loader.setDrawable(0, 0, new StringWrapper("⠸"));
        System.out.println(loader.getString());
        Thread.sleep(duration);
        clear();
        loader.setDrawable(0, 0, new StringWrapper("⠴"));
        System.out.println(loader.getString());
        Thread.sleep(duration);
        clear();
        loader.setDrawable(0, 0, new StringWrapper("⠦"));
        System.out.println(loader.getString());
        Thread.sleep(duration);
        clear();
        loader.setDrawable(0, 0, new StringWrapper("⠇"));
        System.out.println(loader.getString());
        Thread.sleep(duration);
        clear();
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
