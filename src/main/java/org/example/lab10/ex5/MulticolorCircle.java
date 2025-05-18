package org.example.lab10.ex5;

import javax.swing.*;
import java.awt.*;

public class MulticolorCircle extends JPanel {
  private float hue = 0.0f;

  public MulticolorCircle() {
    Timer timer =
        new Timer(
            10,
            e -> {
              hue += 0.01f;
              if (hue == 1) {
                hue = 0.0f;
              }
              repaint();
            });
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    int width = getWidth();
    int height = getHeight();

    int radius = 100;

    g.setColor(new Color(Color.HSBtoRGB(hue, 1.0f, 1.0f)));
    g.fillOval((width - radius) / 2, (height - radius) / 2, radius, radius);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);

    frame.add(new MulticolorCircle());

    frame.setVisible(true);
  }
}
