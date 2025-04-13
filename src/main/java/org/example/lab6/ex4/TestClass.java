package org.example.lab6.ex4;

public class TestClass {
  public static void testException() throws SuperException {
    throw new MiniException("This is a mini exception");
  }

  public static void testSuperException() throws SuperException {
    throw new SuperException("This is a super exception");
  }

  public static void main(String[] args) {
    try {
      //      testException();
      testSuperException();
    } catch (MiniException e) {
      System.out.println("Caught MiniException: " + e.getMessage());
    } catch (SuperException e) {
      System.out.println("Caught SuperException: " + e.getMessage());
    }
  }
}
