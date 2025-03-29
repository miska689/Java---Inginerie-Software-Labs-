package org.example.lab4;

import java.util.Random;
import org.example.lab3.TicTacToe;

public class Children {
  public String name;
  public String dateOfBirth;

  public Children(String name, String dateOfBirth) {
    this.name = name;
    this.dateOfBirth = dateOfBirth; // format: dd/mm/yyyy
  }

  private int dateToAge() {
    return 2025 - Integer.parseInt(dateOfBirth.split("/")[2]);
  }

  public void sayHello() {
    System.out.println("Hello, my name is " + name);
  }

  public void sayAge() {
    System.out.println("I'am " + dateToAge() + " years old");
  }

  public void calculateSomething(int a, int b) {
    if (b >= 10 || b <= -10 || a >= 10 || a <= -10) {
      System.out.println("I can't calculate this");
      return;
    }

    System.out.println("The result is " + (a + b));
  }

  public void sayAlphabet(boolean inReverse) {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    if (inReverse) {
      for (int i = alphabet.length - 1; i >= 0; i--) {
        System.out.print(alphabet[i] + " ");
      }
    } else {
      for (char c : alphabet) {
        System.out.print(c + " ");
      }
    }
    System.out.println();
  }

  public void sayGoodbye() {
    System.out.println("Goodbye!");
  }

  public void drawChessboard(int n) {
    Random random = new Random();

    String[] colors = {"black", "white", "green", "yellow", "blue", "red", "purple", "orange"};

    String[] twoColors = new String[2];

    twoColors[0] = colors[random.nextInt(colors.length)];
    twoColors[1] = colors[random.nextInt(colors.length)];

    int[][] board = new int[n][n];

    for (int i = 0; i < n * n; i++) {
      board[i / n][i % n] = i % 2;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(board[i][j] == 0 ? twoColors[0] : twoColors[1]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  public void playTicTacToe() throws InterruptedException {
    TicTacToe ticTacToe = new TicTacToe(3);
    ticTacToe.runGame();
  }

  public static void main(String[] args) throws InterruptedException {
    Children children = new Children("John", "01/01/2015");

    children.sayHello();
    children.sayAge();
    children.calculateSomething(5, 3);
    children.sayAlphabet(false);
    children.sayAlphabet(true);
    children.drawChessboard(8);
    children.playTicTacToe();
    // children.sayGoodbye();
  }
}
