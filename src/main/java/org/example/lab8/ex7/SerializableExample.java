package org.example.lab8.ex7;

import java.io.*;
import java.util.*;

class IntSerializable implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private final List<Integer> values;

  public IntSerializable() {
    values = new ArrayList<>();
  }

  public void addValue(int value) {
    values.add(value);
  }

  public void sort() {
    Collections.sort(values);
  }

  public void printValue() {
    System.out.println("Values: " + values);
  }
}

public class SerializableExample {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    IntSerializable intSerializable = new IntSerializable();

    System.out.print("Number of values to be added: ");
    int n = scanner.nextInt();

    for (int i = 0; i < n; i++) {
      System.out.print("Value " + (i + 1) + ": ");
      int value = scanner.nextInt();
      intSerializable.addValue(value);
    }

    intSerializable.sort();

    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("date.ser"))) {
      out.writeObject(intSerializable);
      System.out.println("Your object has been serialized.");
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("date.ser"))) {
      IntSerializable inIntSerializable = (IntSerializable) in.readObject();
      System.out.println("Your object has been deserialized.");
      inIntSerializable.printValue();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    scanner.close();
  }
}
