package org.example.lab10.ex3;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Image extends JPanel {
  private BufferedImage image;
  private final String filename;

  public Image(String imagePath, JFrame frame) {
    filename = new File(imagePath).getName();
    try {
      image = ImageIO.read(new File(filename));
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
    frame.setSize(image.getWidth(this), image.getHeight(this));
    setVisible(true);
  }

  @Override
  public void paintComponent(Graphics g) {
    if (image != null) {
      g.drawImage(image, 0, 0, this);
      g.setFont(new Font("Arial", Font.PLAIN, 16));
      g.setColor(new Color(50, 100, 150));
      int textWidth = g.getFontMetrics().stringWidth(filename);
      int x = (getWidth() - textWidth) / 2;
      int y = image.getHeight(this) - 10;
      g.drawString(filename, x, y);
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Image");
    frame.add(new Image("cat.jpeg", frame));
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
