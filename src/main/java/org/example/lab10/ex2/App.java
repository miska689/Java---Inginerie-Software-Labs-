package org.example.lab10.ex2;

import java.awt.*;

public class App extends Frame {
  MainCanvas canvas = new MainCanvas();

  public App() {
    setTitle("My Application");
    setSize(800, 600);
    setLayout(new BorderLayout());
    setVisible(true);
    add(canvas, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    App myApp = new App();
  }
}
