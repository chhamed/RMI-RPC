package com.example.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 1234);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Scanner scanner = new Scanner(System.in)) {

      System.out.println("Connecté au serveur.");

      while (true) {
        System.out.println("1. Addition\n2. Multiplication\n3. Soustraction\n4. Division\n5. Quitter");
        int choix = scanner.nextInt();

        if (choix == 5)
          break;

        System.out.print("Entrez le premier nombre : ");
        double a = scanner.nextDouble();
        System.out.print("Entrez le second nombre : ");
        double b = scanner.nextDouble();

        // Envoyer la requête au serveur
        switch (choix) {
          case 1:
            out.writeUTF("addition");
            break;
          case 2:
            out.writeUTF("multiplication");
            break;
          case 3:
            out.writeUTF("soustraction");
            break;
          case 4:
            out.writeUTF("division");
            break;
          case 5:
            break;
          default:
            System.out.println("Choix invalide.");
            continue;
        }

        out.writeDouble(a);
        out.writeDouble(b);
        out.flush();

        // Lire la réponse du serveur
        double result = in.readDouble();
        System.out.println("Résultat : " + result);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
