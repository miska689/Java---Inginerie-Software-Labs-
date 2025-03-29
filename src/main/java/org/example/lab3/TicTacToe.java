package org.example.lab3;

import java.util.*;

import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class TicTacToe implements NativeKeyListener {
  private final int size;
  private final int[][] board;
  private int selectedSquare;
  private int gameStatus;
  private ArrayList<Integer> availableSquare;

  private final int[][] magicSquare = {
    {2, 7, 6},
    {9, 5, 1},
    {4, 3, 8}
  };

  public TicTacToe(int size) {
    if (size < 3) {
      throw new IllegalArgumentException("Size must be at least 3.");
    }

    this.size = size;
    this.board = new int[size][size];
    this.availableSquare = new ArrayList<>();
    this.selectedSquare = 0;
    this.gameStatus = 0;

    for (int i = 0; i < size * size; i++) {
      availableSquare.add(i);
    }
  }

  /**
   * Prints the current state of the TicTacToe board to the console. Highlights the currently
   * selected square with an underline.
   */
  private void printBoard() {
    String underline;
    String reset;

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i * size + j == selectedSquare) {
          underline = "\033[4m";
          reset = "\033[0m";
        } else {
          underline = "";
          reset = "";
        }
        if (board[i][j] == 0) {
          System.out.print(underline + "*" + reset + " ");
        } else if (board[i][j] == 1) {
          System.out.print(underline + "X" + reset + " ");
        } else {
          System.out.print(underline + "O" + reset + " ");
        }
      }
      System.out.println();
    }
  }

  /**
   * Returns the scores of the squares in the 3x3 square starting at (sx, sy).
   *
   * @param sx The x-coordinate of the top-left corner of the 3x3 square.
   * @param sy The y-coordinate of the top-left corner of the 3x3 square.
   * @return A list of two lists, where the first list contains the scores of the X squares and the
   *     second list contains the scores of the O squares.
   */
  private ArrayList<List<Integer>> getScore(int sx, int sy) {
    ArrayList<List<Integer>> scores = new ArrayList<>();
    scores.add(new ArrayList<>()); // X
    scores.add(new ArrayList<>()); // O

    for (int i = sx; i < sx + 3; i++) {
      for (int j = sy; j < sy + 3; j++) {
        if (board[i][j] != 0) {
          if (board[i][j] == 1) {
            scores.get(0).add(magicSquare[i - sx][j - sy]);
          } else if (board[i][j] == 2) {
            scores.get(1).add(magicSquare[i - sx][j - sy]);
          }
        }
      }
    }

    return scores;
  }

  /**
   * Checks if a player has won the game.
   *
   * @return 0 if no player has won, 1 if player X has won, and 2 if player O has won.
   */
  private int checkWin() {
    for (int sx = 0; sx < (size / 3 + size % 3); sx++) {
      for (int sy = 0; sy < (size / 3 + size % 3); sy++) {
        ArrayList<List<Integer>> scores = getScore(sx, sy);

        if (scores.get(0).size() >= 3) {
          for (Integer x : scores.get(0)) {
            for (Integer y : scores.get(0)) {
              if (Objects.equals(x, y)
                  || Objects.equals(x, 15 - x - y)
                  || Objects.equals(y, 15 - x - y)) {
                continue;
              }
              if (scores.get(0).contains(15 - x - y)) {
                return 1;
              }
            }
          }
        }

        if (scores.get(1).size() >= 3) {
          for (Integer x : scores.get(1)) {
            for (Integer y : scores.get(1)) {
              if (Objects.equals(x, y)
                  || Objects.equals(x, 15 - x - y)
                  || Objects.equals(y, 15 - x - y)) {
                continue;
              }
              if (scores.get(1).contains(15 - x - y)) {
                return 2;
              }
            }
          }
        }
      }
    }

    return 0;
  }

  /** Makes a move for the computer player. */
  private void computerMove() {
    if (availableSquare.isEmpty()) {
      return;
    }

    Random random = new Random();

    int randomIndex = random.nextInt(availableSquare.size());

    Integer randomSquare = availableSquare.get(randomIndex);

    board[randomSquare / size][randomSquare % size] = 2;

    availableSquare.remove(randomIndex);
  }

  /**
   * Handles the key press events.
   *
   * @param e The key event.
   */
  @Override
  public void nativeKeyPressed(NativeKeyEvent e) {
    switch (e.getKeyCode()) {
      case NativeKeyEvent.VC_UP:
        selectedSquare -= size;
        if (selectedSquare < 0) {
          selectedSquare = size * size - 1;
        }
        System.out.println("\033[H\033[2J");
        printBoard();
        break;
      case NativeKeyEvent.VC_DOWN:
        selectedSquare += size;
        if (selectedSquare >= size * size) {
          selectedSquare = 0;
        }
        System.out.println("\033[H\033[2J");
        printBoard();
        break;
      case NativeKeyEvent.VC_LEFT:
        selectedSquare--;
        if (selectedSquare < 0) {
          selectedSquare = size * size - 1;
        }
        System.out.println("\033[H\033[2J");
        printBoard();
        break;
      case NativeKeyEvent.VC_RIGHT:
        selectedSquare++;
        if (selectedSquare >= size * size) {
          selectedSquare = 0;
        }
        System.out.println("\033[H\033[2J");
        printBoard();
        break;
      case NativeKeyEvent.VC_ENTER:
        if (board[selectedSquare / size][selectedSquare % size] == 0) {
          board[selectedSquare / size][selectedSquare % size] = 1;
          availableSquare.remove(Integer.valueOf(selectedSquare));
          computerMove();
          gameStatus = checkWin();
        }
        System.out.println("\033[H\033[2J");
        printBoard();
        break;
    }
    if (gameStatus != 0) {
      System.out.println("Player " + (gameStatus == 1 ? "X" : "O") + " wins!");
      try {
        com.github.kwhat.jnativehook.GlobalScreen.unregisterNativeHook();
      } catch (NativeHookException ex) {
        throw new RuntimeException(ex);
      }
    } else if (availableSquare.isEmpty()) {
      System.out.println("It's a draw!");
      try {
        com.github.kwhat.jnativehook.GlobalScreen.unregisterNativeHook();

      } catch (NativeHookException ex) {
        throw new RuntimeException(ex);
      }
    }
  }

  public void runGame() throws InterruptedException {
    com.github.kwhat.jnativehook.GlobalScreen.addNativeKeyListener(this);

    try {
      com.github.kwhat.jnativehook.GlobalScreen.registerNativeHook();
    } catch (Exception ex) {
      ex.printStackTrace();
      System.exit(1);
    }

    System.out.println("\033[H\033[2J");
    printBoard();
  }
}
