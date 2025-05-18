package org.example.lab10.ex2;

import java.awt.*;

public class MainCanvas extends Canvas {
  public MainCanvas() {
    setVisible(true);
  }

  @Override
  public void paint(Graphics g) {
    int width = getWidth();
    int height = getHeight();

    int radius = width > height ? height / 2 : width / 2;

    g.setColor(Color.RED);
    g.fillOval(width / 2 - radius, height / 2 - radius, radius * 2, radius * 2);
  }
}
