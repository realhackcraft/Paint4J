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
    StringWrapper[] labels = { new StringWrapper("🖌️ "), new StringWrapper("🗑️ ") };
    toolbox = new Toolbox(labels);
    Pixel[][] pixels = new Pixel[80][24];
    for (int i = 0; i < pixels.length; i++) {
      Pixel[] row = pixels[i];
      for (int j = 0; j < row.length; j++) {
        pixels[i][j] = new Pixel();
      }
    }
    while (true) {
      loop();
    }
  }

  public void loop() {
    clear();
    System.out.println(window.getString());
    System.out.println(toolbox.getString());
    String command = input();
    switch (command.toLowerCase()) {
      case "a":
        window.moveX(-1);
        break;
      case "d":
        window.moveX(1);
        break;
      case "w":
        window.moveY(-1);
        break;
      case "s":
        window.moveY(1);
        break;
      case ",":
        toolbox.move(-1);
        break;
      case ".":
        toolbox.move(1);
        break;
      case " ":
        draw();
        break;
      default:
        break;
    }
  }

  public void draw() {
    int selected = toolbox.getSelected();
    switch (selected) {
      case 0:
        window.setPixel(new Pixel(true, "\033[0;31m"));
        break;
      case 1:
        window.setPixel(new Pixel(false, "\033[0;31m"));
        break;
      default:
        break;
    }
  }

  public String input() {
    System.out.print("Use WASD to move cursor; use , and . to change tool: ");
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
