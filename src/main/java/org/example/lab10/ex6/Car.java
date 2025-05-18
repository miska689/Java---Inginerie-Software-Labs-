package org.example.lab10.ex6;

import javax.swing.*;
import java.awt.*;

public class Car extends JPanel {
  public int moveX = 0;

  public Car() {
    Timer timer =
        new Timer(
            10,
            e -> {
              moveX -= 5;
              if (moveX < -100) {
                moveX = getWidth();
              }
              repaint();
            });
    timer.start();
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int height = getHeight();

    g.setColor(Color.GREEN);
    g.fillOval(100 + moveX, height / 2, 50, 50);
    g.fillOval(300 + moveX, height / 2, 50, 50);
    g.setColor(Color.BLUE);
    g.fillRect(50 + moveX, height / 2 - 50, 350, 50);
    g.setColor(Color.BLUE);
    g.fillRect(350 / 2 - 50 + moveX, height / 2 - 100, 350 / 2, 50);
    g.setColor(Color.YELLOW);
    g.fillRect(50 + moveX, height / 2 - 45, 30, 30);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Car");
    Car car = new Car();
    frame.add(car);
    frame.setSize(450, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
