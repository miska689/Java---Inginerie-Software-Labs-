package org.example.lab11.ex3;

import javax.swing.*;
import java.awt.*;

public class PaintPanel extends JPanel {
  public PaintPanel() {
    setLayout(new GridLayout(0, 2));
    setPreferredSize(new Dimension(400, 400));
    setBackground(Color.WHITE);
    setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    add(new JLabel("Here you can draw! )"));
  }
}
