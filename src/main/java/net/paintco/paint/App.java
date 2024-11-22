package net.paintco.paint;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    App app = new App();
    app.initialize();
  }

  public void initialize() {
    clear();
    System.out.println(Utils.makeBox("Welcome to Paint©!"));
    load();
    String[] hello = { "Done!", "Enjoy using Paint©!" };
    System.out.println(Utils.makeBox(hello));
  }

  public void clear() {
    System.out.println("\033[H");
    System.out.println("\033[J");
  }

  public void load() {
    try {
      Thread.sleep(1000);
      clear();
      int duration = 100;
      for (int i = 0; i < 5; i++) {
        System.out.println(Utils.makeBox("⠋"));
        Thread.sleep(duration);
        clear();
        System.out.println(Utils.makeBox("⠙"));
        Thread.sleep(duration);
        clear();
        System.out.println(Utils.makeBox("⠸"));
        Thread.sleep(duration);
        clear();
        System.out.println(Utils.makeBox("⠴"));
        Thread.sleep(duration);
        clear();
        System.out.println(Utils.makeBox("⠦"));
        Thread.sleep(duration);
        clear();
        System.out.println(Utils.makeBox("⠇"));
        Thread.sleep(duration);
        clear();
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
