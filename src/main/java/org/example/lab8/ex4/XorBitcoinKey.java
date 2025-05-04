package org.example.lab8.ex4;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XorBitcoinKey {
  private static final int KEY_LENGTH = 256;

  public static void main(String[] args) {
    try {
      byte[] privateKey = new byte[KEY_LENGTH];
      try (FileInputStream fis =
          new FileInputStream(System.getProperty("user.dir") + "/private_key.bin")) {
        int read = fis.read(privateKey);
        if (read != KEY_LENGTH) {
          System.err.println(
              "The file contains only "
                  + read
                  + " bytes, but "
                  + KEY_LENGTH
                  + " bytes are expected.");
          return;
        }
      }

      System.out.println("Enter the public key (exactly " + KEY_LENGTH + " characters):");
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      String publicKeyStr = reader.readLine();
      if (publicKeyStr == null || publicKeyStr.length() != KEY_LENGTH) {
        System.err.println("The public key must be exactly " + KEY_LENGTH + " characters long!");
        return;
      }

      byte[] publicKey = publicKeyStr.getBytes(StandardCharsets.ISO_8859_1);

      byte[] txId = new byte[KEY_LENGTH];
      for (int i = 0; i < KEY_LENGTH; i++) {
        txId[i] = (byte) (privateKey[i] ^ publicKey[i]);
      }

      try (FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/txId")) {
        fos.write(txId);
      }

      System.out.println("The transaction identifier has been written to the txId file.");

    } catch (IOException e) {
      System.err.println("I/O Error: " + e.getMessage());
    }
  }
}
