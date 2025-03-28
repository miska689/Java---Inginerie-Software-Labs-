package org.example.lab4;

public class XClass {
  private char[] chars;

  protected String string;

  int number;

  public XClass(char[] chars, String string, int number) {
    this.chars = chars;
    this.string = string;
    this.number = number;
  }

  public char[] getChars() {
    return chars;
  }

  public void setChars(char[] chars) {
    this.chars = chars;
  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public int getNumber() {
    return number;
  }

  public static void main(String[] args) {
    XClass xClass = new XClass(new char[] {'a', 'b', 'c'}, "Hello, World!", 42);

    System.out.println(xClass.getChars());
    System.out.println(xClass.getString());
    System.out.println(xClass.getNumber());
  }
}
