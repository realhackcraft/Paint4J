package net.paintco.paint;

import java.util.Scanner;

/** Hello world! */
public class App {
  Scanner console = new Scanner(System.in);
  Window w;

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
    pane = new Pane(80, 24);
    Pixel[][] pixels = new Pixel[80][24];
    for (int i = 0; i < pixels.length; i++) {
      Pixel[] row = pixels[i];
      for (int j = 0; j < row.length; j++) {
        pixels[i][j] = new Pixel();
      }
    }
    loop();
  }

  public void loop() {
    System.out.println(pane.getString());
    String command = input();
    switch (command.toLowerCase()) {
      case 'a':
        w.move_x(-1);
        break;
      case 'd':
        w.move_x(1);
        break;
      case 'w':
        w.move_y(-1)
        break;
      case 's':
        w.move_y(1)
        break;
      case ',':

        break;
      case '.':
                
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
