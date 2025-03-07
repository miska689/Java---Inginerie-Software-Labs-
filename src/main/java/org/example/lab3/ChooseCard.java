package org.example.lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ChooseCard {
  public static boolean chooseCard(List<String> cards) {
    Random random = new Random();

    String card = cards.get(random.nextInt(cards.size()));

    System.out.println("Computer has chosen the card: " + card);

    if (checkCard(card)) {
      return true;
    }

    cards.remove(card);

    return false;
  }

  public static boolean checkCard(String card) {
    if (card.charAt(card.length() - 1) != 'S') {
      return false;
    }

    String numberOnly= card.replaceAll("[^0-9]", "");

    try{
      int number = Integer.parseInt(numberOnly);
      if ( number < 8) {
        return false;
      }
    } catch (NumberFormatException e) {
      return true;
    }

    return true;
  }

  public static void main() {
    String[] cards = {
      "6H", "6D", "6S", "6C", "7H", "7D", "7S", "7C", "8H", "8D", "8S", "8C", "9H", "9D", "9S",
      "9C", "10H", "10D", "10S", "10C", "JH", "JD", "JS", "JC", "QH", "QD", "QS", "QC", "KH", "KD",
      "KS", "KC", "AH", "AD", "AS", "AC",
    };

    List<String> cardsList = Arrays.asList(cards);
  }
}
