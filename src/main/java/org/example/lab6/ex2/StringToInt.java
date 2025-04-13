package org.example.lab6.ex2;

import java.util.Arrays;
import java.util.Collections;

public class StringToInt {
  String string;
  int[] arr;
  int index;

  public StringToInt(String string, int index) {
    this.string = string;
    this.index = index;

    try {
      System.out.println("Number contains " + string.length() + " characters.");
      this.arr = new int[string.length()];

      int number = Integer.parseInt(string);
      System.out.println("Number: " + number);

      for (int i = 0; number > 0; i++) {
        this.arr[i] = number % 10;
        number /= 10;
      }

      System.out.print("Digits: ");
      for (int i = this.arr.length - 1; i >= 0; i--) {
        System.out.print(this.arr[i] + " ");
      }

      Collections.reverse(Arrays.asList(this.arr));

      System.out.println("Digit at index " + index + ": " + this.arr[index]);

      System.out.println("arr[index] / arr[index + 1] = " + this.arr[index] / this.arr[index + 1]);

    } catch (NumberFormatException e) {
      System.out.println("Invalid number!");
    } catch (NullPointerException e) {
      System.out.println("Number is null!");
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Index out of bounds!");
    } catch (ArithmeticException e) {
      System.out.println("Division by zero!");
    } finally {
      System.out.println("Am prins sau nu excepții");
    }
  }

  public static void main(String[] args) {
    StringToInt stringToInt = new StringToInt("103456", 6);
  }
}
