package org.example.lab11.ex3;

import javax.swing.*;
import java.awt.*;

public class TabbedView {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Tabbed View");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new BorderLayout());

    JTabbedPane tabbedPane = new JTabbedPane();

    tabbedPane.addTab("Shapes", new ShapePanel());
    tabbedPane.addTab("Fonts", new FontPanel());
    tabbedPane.addTab("Paint", new PaintPanel());

    frame.add(tabbedPane, BorderLayout.CENTER);
    frame.setVisible(true);
  }
}
