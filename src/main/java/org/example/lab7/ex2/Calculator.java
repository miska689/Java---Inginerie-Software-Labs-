package org.example.lab7.ex2;

class Calculator<T extends Number> {
  public T add(T a, T b) {
    if (a instanceof Integer && b instanceof Integer) {
      return (T) Integer.valueOf(a.intValue() + b.intValue());
    } else if (a instanceof Float && b instanceof Float) {
      return (T) Float.valueOf(a.floatValue() + b.floatValue());
    } else if (a instanceof Double && b instanceof Double) {
      return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
    }
    throw new IllegalArgumentException("Incompatible data types for addition.");
  }

  public T subtract(T a, T b) {
    if (a instanceof Integer && b instanceof Integer) {
      return (T) Integer.valueOf(a.intValue() - b.intValue());
    } else if (a instanceof Float && b instanceof Float) {
      return (T) Float.valueOf(a.floatValue() - b.floatValue());
    } else if (a instanceof Double && b instanceof Double) {
      return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
    }
    throw new IllegalArgumentException("Incompatible data types for subtraction.");
  }

  public T multiply(T a, T b) {
    if (a instanceof Integer && b instanceof Integer) {
      return (T) Integer.valueOf(a.intValue() * b.intValue());
    } else if (a instanceof Float && b instanceof Float) {
      return (T) Float.valueOf(a.floatValue() * b.floatValue());
    } else if (a instanceof Double && b instanceof Double) {
      return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
    } else {
      throw new UnsupportedOperationException("Multiplication is not supported for String type.");
    }
  }

  public T divide(T a, T b) {
    if (b.doubleValue() == 0) {
      throw new ArithmeticException("Division by zero is not allowed.");
    }
    if (a instanceof Integer && b instanceof Integer) {
      return (T) Double.valueOf((double) a.intValue() / b.intValue());
    } else if (a instanceof Float && b instanceof Float) {
      return (T) Float.valueOf(a.floatValue() / b.floatValue());
    } else if (a instanceof Double && b instanceof Double) {
      return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
    } else {
      throw new UnsupportedOperationException("Division is not supported for String type.");
    }
  }

  public static void main(String[] args) {
    Calculator<Integer> intCalculator = new Calculator<>();
    System.out.println("Integer addition: " + intCalculator.add(5, 3)); // Output: 8
    System.out.println("Integer subtraction: " + intCalculator.subtract(10, 4)); // Output: 6

    Calculator<Float> floatCalculator = new Calculator<>();
    System.out.println("Float addition: " + floatCalculator.add(2.5f, 1.5f)); // Output: 4.0
    System.out.println(
        "Float multiplication: " + floatCalculator.multiply(2.0f, 3.5f)); // Output: 7.0

    try {
      intCalculator.divide(10, 0);
    } catch (ArithmeticException e) {
      System.err.println("Division by zero error: " + e.getMessage());
    }
  }
}

class CalculatorOverloading {
  public int add(int a, int b) {
    return a + b;
  }

  public float add(float a, float b) {
    return a + b;
  }

  public double add(double a, double b) {
    return a + b;
  }

  public String add(String a, String b) {
    return a + b;
  }

  public int subtract(int a, int b) {
    return a - b;
  }

  public float subtract(float a, float b) {
    return a - b;
  }

  public double subtract(double a, double b) {
    return a - b;
  }

  public String subtract(String a, String b) {
    // Simulates subtraction by removing the first occurrence of b from a
    int index = a.indexOf(b);
    if (index != -1) {
      return a.substring(0, index) + a.substring(index + b.length());
    } else {
      return a; // If b is not found in a, return a
    }
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public float multiply(float a, float b) {
    return a * b;
  }

  public double multiply(double a, double b) {
    return a * b;
  }

  public double divide(int a, int b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero is not allowed.");
    }
    return (double) a / b;
  }

  public float divide(float a, float b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero is not allowed.");
    }
    return a / b;
  }

  public double divide(double a, double b) {
    if (b == 0) {
      throw new ArithmeticException("Division by zero is not allowed.");
    }
    return a / b;
  }

  public static void main(String[] args) {
    CalculatorOverloading calculator = new CalculatorOverloading();

    System.out.println("Integer addition: " + calculator.add(5, 3)); // Output: 8
    System.out.println("Integer subtraction: " + calculator.subtract(10, 4)); // Output: 6
    System.out.println("Integer multiplication: " + calculator.multiply(2, 6)); // Output: 12
    System.out.println("Integer division: " + calculator.divide(15, 3)); // Output: 5.0

    System.out.println("Float addition: " + calculator.add(2.5f, 1.5f)); // Output: 4.0
    System.out.println("Float multiplication: " + calculator.multiply(2.0f, 3.5f)); // Output: 7.0
    System.out.println("Float division: " + calculator.divide(7.5f, 2.5f)); // Output: 3.0

    System.out.println(
        "String concatenation: " + calculator.add("Hello", " world")); // Output: Hello world
    System.out.println(
        "String subtraction: " + calculator.subtract("banana", "nan")); // Output: baa

    try {
      System.out.println("Division by zero: " + calculator.divide(10, 0));
    } catch (ArithmeticException e) {
      System.err.println("Division by zero error: " + e.getMessage());
    }
  }
}
