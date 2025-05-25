package org.example.lab11.ex1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Calculator {
  public static void main(String[] args) {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");

    int width = 400;
    int height = 600;

    JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);

    JPanel textPanel = new JPanel();
    textPanel.setBounds(0, 0, width, 100);
    textPanel.setLayout(new BorderLayout());
    textPanel.setBorder(new LineBorder(Color.BLACK, 1));

    JTextField textField = new JTextField('0');
    textField.setEditable(false);
    textPanel.add(textField, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setBounds(0, 100, width, height - 100);
    buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
    buttonPanel.setBorder(new LineBorder(Color.BLACK, 1));

    String[] buttons = {
      "7", "8", "9", "/",
      "4", "5", "6", "*",
      "1", "2", "3", "-",
      "0", ".", "=", "+"
    };

    for (String text : buttons) {
      JButton button = new JButton(text);
      button.setFont(new Font("Arial", Font.PLAIN, 24));
      button.setBorder(new LineBorder(Color.BLACK, 1));
      button.addActionListener(
          e -> {
            if (text.equals("=")) {
              try {
                String result = engine.eval(textField.getText()).toString();
                textField.setText(result);
              } catch (Exception ex) {
                textField.setText("Error");
                ex.getStackTrace();
              }
            } else {
              textField.setText(
                  textField.getText().equals("0") ? text : textField.getText() + text);
            }
          });
      buttonPanel.add(button);
    }
    frame.add(textPanel);
    frame.add(buttonPanel);

    frame.setVisible(true);
  }
}
