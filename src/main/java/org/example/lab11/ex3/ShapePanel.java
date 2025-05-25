package org.example.lab11.ex3;

import javax.swing.*;
import java.awt.*;

public class ShapePanel extends JPanel {
  public ShapePanel() {
    // Set up the panel with a grid layout
    setLayout(new GridLayout(0, 2));
    setPreferredSize(new Dimension(400, 400));
    setBackground(Color.WHITE);
    setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    add(new JLabel("Here you can choose a shape!"));
  }
}
