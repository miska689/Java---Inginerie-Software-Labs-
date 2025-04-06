package org.example.lab5.ex6;

public class Pawn implements ChessPiece {
  private int[] position;

  @Override
  public int[][] getPosition(int[] position, String geographicPosition) {
    int[][] moves = new int[1][2];

    if (geographicPosition.compareTo("N") != 0) {
      return null;
    }

    moves[0][0] = position[0];
    moves[0][1] = position[1] == 7 ? 7 : position[1] + 1;

    return moves;
  }
}
