package org.example.lab7.ex3;

public class SetterGetter<T> {
  private T value;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    try {
      this.value = value;
    } catch (Exception e) {
      System.out.println("Error setting value: " + e.getMessage());
    }
  }
}

class Person {
  private final SetterGetter<String> name;
  private final SetterGetter<Integer> age;

  public Person(String name, int age) {
    this.name = new SetterGetter<>();
    this.age = new SetterGetter<>();

    this.name.setValue(name);
    this.age.setValue(age);
  }

  public static void main(String[] args) {
    Person person = new Person("John Doe", 30);

    System.out.println("Name: " + person.name.getValue());
    System.out.println("Age: " + person.age.getValue());
  }
}
