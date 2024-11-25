package net.paintco.paint;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    App app = new App();
    app.initialize();
  }

  public void initialize() {
    clear();
    Pane welcome = new Pane(18, 1);
    for (int i = 0; i < 18; i++) {
      welcome.setDrawable(0, i, new StringWrapper("Welcome to Paint©!".charAt(i)));
    }
    System.out.println(welcome.getString());
    load();
    Pane done = new Pane(19, 2);
    String[] doneString = { "Done!", "Enjoy using Paint©!" };
    for (int i = 0; i < doneString.length; i++) {
      String string = doneString[i];
      for (int j = 0; j < string.length(); j++) {
        done.setDrawable(j, i, new StringWrapper(string.charAt(i)));
      }
    }
    System.out.println(done.getString());
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
