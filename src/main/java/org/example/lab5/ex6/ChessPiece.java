package org.example.lab5.ex6;

public interface ChessPiece {
  /**
   * Returns the name of the chess piece.
   *
   * @param position the position of the chess piece on the board
   * @param geographicPosition the geographic position of the chess piece {"N", "S", "E", "W", "NE",
   *     "NW", "SE", "SW"}
   * @return available moves of the chess piece
   */
  public int[][] getPosition(int[] position, String geographicPosition);
}
