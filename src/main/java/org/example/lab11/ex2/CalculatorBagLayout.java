package org.example.lab11.ex2;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CalculatorBagLayout {
  public static void main(String[] args) {
    int width = 400;
    int height = 600;

    JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height);
    frame.setLocationRelativeTo(null);

    GridBagConstraints gbc = new GridBagConstraints();

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridBagLayout());
    buttonPanel.setBorder(new LineBorder(Color.BLACK, 1));

    // Text field row setup (span all 4 columns)
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 4;
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    buttonPanel.add(new JTextField("0"), gbc);

    gbc.gridwidth = 1;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.BOTH;

    String[] buttons = {
      "7", "8", "9", "/",
      "4", "5", "6", "*",
      "1", "2", "3", "-",
      "0", ".", "=", "+"
    };

    // Add buttons in 4 rows and 4 columns
    int index = 0;
    for (int row = 1; row <= 4; row++) {
      for (int col = 0; col < 4; col++) {
        gbc.gridx = col;
        gbc.gridy = row;
        JButton button = new JButton(buttons[index++]);
        button.setFont(new Font("Arial", Font.PLAIN, 24));
        button.setBorder(new LineBorder(Color.BLACK, 1));
        buttonPanel.add(button, gbc);
      }
    }

    frame.add(buttonPanel);
    frame.setVisible(true);
  }
}
