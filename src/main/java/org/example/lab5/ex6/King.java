package org.example.lab5.ex6;

public class King implements ChessPiece {
  private int[] position;

  public King(int[] position, String color) {
    this.position = position;
  }

  @Override
  public int[][] getPosition(int[] position, String geographicPosition) {
    this.position = position;
    int[][] moves = new int[8][2];

    switch (geographicPosition) {
      case "N":
        moves[0][0] = position[0];
        moves[0][1] = position[1] == 7 ? 7 : position[1] + 1;
        break;
      case "S":
        moves[0][0] = position[0];
        moves[0][1] = position[1] == 0 ? 0 : position[1] - 1;
        break;
      case "E":
        moves[0][0] = position[0] == 7 ? 7 : position[0] + 1;
        moves[0][1] = position[1];
        break;
      case "W":
        moves[0][0] = position[0] == 0 ? 0 : position[0] - 1;
        moves[0][1] = position[1];
        break;
      case "NW":
        moves[0][0] = position[0] == 0 ? 0 : position[0] - 1;
        moves[0][1] = position[1] == 7 ? 7 : position[1] + 1;
        break;
      case "NE":
        moves[0][0] = position[0] == 7 ? 7 : position[0] + 1;
        moves[0][1] = position[1] == 7 ? 7 : position[1] + 1;
        break;
      case "SW":
        moves[0][0] = position[0] == 0 ? 0 : position[0] - 1;
        moves[0][1] = position[1] == 0 ? 0 : position[1] - 1;
        break;
      case "SE":
        moves[0][0] = position[0] == 7 ? 7 : position[0] + 1;
        moves[0][1] = position[1] == 0 ? 0 : position[1] - 1;
        break;
      default:
        System.out.println("Invalid geographic position");
        return null;
    }

    return moves;
  }
}
