package com.example.server;

import com.example.service.CalculatriceInterface;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(1234)) {
      System.out.println("Serveur démarré et en attente de connexions...");

      CalculatriceInterface calculatrice = new CalculatriceServiceImpl();

      while (true) {
        try (Socket clientSocket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

          System.out.println("Connexion reçue d'un client.");

          // Lire la requête
          String operation = in.readUTF();
          double a = in.readDouble();
          double b = in.readDouble();

          // Traiter la requête

          double result;
          switch (operation) {
            case "addition":
              result = calculatrice.addition(a, b);
              break;
            case "multiplication":
              result = calculatrice.multiplication(a, b);
              break;
            case "soustraction":
              result = calculatrice.soustraction(a, b);
              break;
            case "division":
              result = calculatrice.division(a, b);
              break;
            default:
              throw new IllegalArgumentException("Opération inconnue : " + operation);
          }

          // Envoyer le résultat au client
          out.writeDouble(result);
          out.flush();
        } catch (Exception e) {
          System.err.println("Erreur dans le traitement : " + e.getMessage());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
