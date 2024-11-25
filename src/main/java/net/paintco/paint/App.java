package net.paintco.paint;

/** Hello world! */
public class App {
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
    Thread.sleep(1000);
    run();
  }

  public void run() {
    clear();
    Pane pane = new Pane(80, 24);
    Pixel[][] pixels = new Pixel[80][24];
    for (int i = 0; i < pixels.length; i++) {
      Pixel[] row = pixels[i];
      for (int j = 0; j < row.length; j++) {
        pixels[i][j] = new Pixel();
      }
    }
    System.out.println(pane.getString());
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
