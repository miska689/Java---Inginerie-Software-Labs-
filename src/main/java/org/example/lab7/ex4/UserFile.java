package org.example.lab7.ex4;

import java.util.*;

public class UserFile {
  private String name;
  private String extension;
  private String type;
  private int size;

  public UserFile() {}

  public UserFile(String name, String extension, String type, int size) {
    this.name = name;
    this.extension = extension;
    this.type = type;
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public String getExtension() {
    return extension;
  }

  public String getType() {
    return type;
  }

  public int getSize() {
    return size;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return name + "." + extension + " (" + type + ", " + size + " bytes)";
  }

  public static Hashtable<String, Integer> predefinedTypes() {
    Hashtable<String, Integer> types = new Hashtable<>();
    types.put("image", 0);
    types.put("text", 1);
    types.put("application", 2);
    types.put("audio", 3);
    types.put("video", 4);
    return types;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Hashtable<String, Integer> types = UserFile.predefinedTypes();
    List<UserFile> files = new ArrayList<>();

    System.out.print("How many files? ");
    int n = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < n; i++) {
      System.out.println("Enter details for file " + (i + 1) + ":");
      System.out.print("Name (without extension): ");
      String name = scanner.nextLine();
      System.out.print("Extension (e.g. txt, jpg): ");
      String ext = scanner.nextLine();
      System.out.print("Type (image, text, application...): ");
      String type = scanner.nextLine();
      System.out.print("Size in bytes: ");
      int size = scanner.nextInt();
      scanner.nextLine(); // Consume the newline character

      if (!types.containsKey(type)) {
        System.out.println("Unknown type. Skipping file.");
        continue;
      }

      files.add(new UserFile(name, ext, type, size));
    }

    System.out.println("\nExtensions grouped by file type:");
    for (String t : types.keySet()) {
      System.out.print(t + ": ");
      files.stream()
          .filter(f -> f.getType().equals(t))
          .map(UserFile::getExtension)
          .distinct()
          .forEach(ext -> System.out.print(ext + " "));
      System.out.println();
    }

    files.sort(Comparator.comparingInt(UserFile::getSize));

    System.out.println("\nFiles sorted by size:");
    for (UserFile file : files) {
      System.out.println(file);
    }
  }
}
