package org.example.lab10.ex4;

import javax.swing.*;
import java.awt.*;

public class TVTestPattern extends JPanel {
  @Override
  protected void paintComponent(Graphics g) {
    int width = getWidth();
    int height = getWidth();

    Color[] colors = {
      Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA,
    };

    int rectWidth = width / colors.length;

    for (int i = 0; i < colors.length; i++) {
      g.setColor(colors[i]);
      g.fillRect(i * rectWidth, 0, rectWidth, height);
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("TV Test Pattern");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);

    frame.add(new TVTestPattern());

    frame.setVisible(true);
  }
}
