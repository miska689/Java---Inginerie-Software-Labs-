package org.example.lab10.ex1;

import javax.swing.*;
import java.awt.*;

public class App extends JPanel {
  public App() {}

  public void paintComponent(Graphics g) {
    int width = getWidth();
    int height = getHeight();

    g.setColor(Color.BLUE);
    g.drawString("Boinceanu Mihail, Gruapa: 2127", width / 2, height / 2);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("My app");
    frame.add(new App());
    frame.setSize(400, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
