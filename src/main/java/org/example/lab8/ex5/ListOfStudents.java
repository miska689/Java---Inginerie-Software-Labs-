package org.example.lab8.ex5;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ListOfStudents {

  public static void main(String[] args) {
    File folder = new File(".");
    String currentYear = "2025";
    Pattern pattern = Pattern.compile("An_" + currentYear + "_Grupa_\\d+\\.txt");
    List<InputStream> inputStreams = new ArrayList<>();

    for (File file : Objects.requireNonNull(folder.listFiles())) {
      if (pattern.matcher(file.getName()).matches()) {
        try {
          inputStreams.add(new FileInputStream(file));
        } catch (FileNotFoundException e) {
          System.err.println("Cannot open file: " + file.getName());
        }
      }
    }

    if (inputStreams.isEmpty()) {
      System.out.println("No files found for year " + currentYear);
      return;
    }

    SequenceInputStream seqInput = new SequenceInputStream(Collections.enumeration(inputStreams));
    List<String> students = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(seqInput))) {
      String line;
      while ((line = reader.readLine()) != null) {
        line = line.trim();
        if (!line.isEmpty()) {
          students.add(line);
        }
      }
    } catch (IOException e) {
      System.err.println("Error reading files: " + e.getMessage());
    }

    for (InputStream is : inputStreams) {
      try {
        is.close();
      } catch (IOException ignored) {
      }
    }

    students.sort(String::compareToIgnoreCase);

    try (BufferedWriter writer =
        new BufferedWriter(new FileWriter("Students_Year_" + currentYear + ".txt"))) {
      for (String student : students) {
        writer.write(student);
        writer.newLine();
      }
      System.out.println("Final file created: Students_Year_" + currentYear + ".txt");
    } catch (IOException e) {
      System.err.println("Error writing final file: " + e.getMessage());
    }
  }
}
