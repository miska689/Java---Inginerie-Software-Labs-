package org.example.lab11.ex3;

import javax.swing.*;
import java.awt.*;

public class FontPanel extends JPanel {
  GridBagConstraints gbc = new GridBagConstraints();
  private final int top = 3, left = 3, bottom = 3, right = 3;
  private Insets insets = new Insets(top, left, bottom, right);

  public FontPanel() {

    setLayout(null);
    setSize(800, 600);

    int width = getWidth();
    int height = getHeight();

    System.out.println("Width: " + width);
    System.out.println("Height: " + height);

    int panelWidth = 400;
    int panelHeight = 400;

    JPanel fontPanel = new JPanel();
    fontPanel.setBounds(
        width / 2 - panelWidth / 2, height / 2 - panelHeight / 2, panelWidth, panelHeight);
    fontPanel.setLayout(new GridBagLayout());
    fontPanel.setBackground(Color.GRAY);
    fontPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    JLabel label = new JLabel("Here you can choose a font!");
    label.setFont(new Font("Arial", Font.PLAIN, 16));
    label.setForeground(Color.white);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    gbc.insets = insets;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 2;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    fontPanel.add(label, gbc);

    // cascade lable
    JLabel fontStyleLabel = new JLabel(" Style");
    fontStyleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    fontStyleLabel.setForeground(Color.white);
    fontStyleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.BOTH;
    fontPanel.add(fontStyleLabel, gbc);

    // add a button
    JComboBox<String> fontComboBox = new JComboBox<>();
    fontComboBox.addItem("Arial");
    fontComboBox.addItem("Times New Roman");
    fontComboBox.addItem("Courier New");
    fontComboBox.addItem("Verdana");
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.BOTH;
    fontPanel.add(fontComboBox, gbc);

    // font size
    JLabel fontSizeLabel = new JLabel(" Size");
    fontSizeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    fontSizeLabel.setForeground(Color.white);
    fontSizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.BOTH;
    fontPanel.add(fontSizeLabel, gbc);

    // add fontsize field
    JTextField fontSizeField = new JTextField();
    fontSizeField.setText("12");
    fontSizeField.setFont(new Font("Arial", Font.PLAIN, 12));
    fontSizeField.setHorizontalAlignment(SwingConstants.CENTER);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.BOTH;
    fontPanel.add(fontSizeField, gbc);

    // font color
    JLabel fontColorLabel = new JLabel(" Color");
    fontColorLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    fontColorLabel.setForeground(Color.white);
    fontColorLabel.setHorizontalAlignment(SwingConstants.CENTER);
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.BOTH;
    fontPanel.add(fontColorLabel, gbc);

    // add color field
    JComboBox<String> colorComboBox = new JComboBox<>();
    colorComboBox.addItem("Red");
    colorComboBox.addItem("Green");
    colorComboBox.addItem("Blue");
    colorComboBox.addItem("Black");
    colorComboBox.addItem("White");
    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.BOTH;
    fontPanel.add(colorComboBox, gbc);

    add(fontPanel, BorderLayout.SOUTH);
  }
}
