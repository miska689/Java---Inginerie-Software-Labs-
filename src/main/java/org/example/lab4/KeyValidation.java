package org.example.lab4;

public class KeyValidation {
  String key; // XXXXX-XXXXX-XXXXX-XXXXX

  public KeyValidation(String key) {
    this.key = key;
  }

  public boolean validate() {
    if (key.split("-").length != 4) {
      return false;
    }

    for (String part : key.split("-")) {
      if (part.length() != 5) {
        return false;
      }
    }

    int nChars = 0;
    int nDigits = 0;

    for (char c : key.toCharArray()) {
      if (Character.isLetter(c)) {
        nChars++;
      } else if (Character.isDigit(c)) {
        nDigits++;
      }
    }

    return nChars != 0 && nDigits > nChars;
  }

  public static void main(String[] args) {
    KeyValidation keyValidation = new KeyValidation("abcd1-12345-abcde-12345");

    System.out.println(keyValidation.validate());
  }
}
