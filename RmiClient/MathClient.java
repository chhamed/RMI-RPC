
import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class MathClient {
  public static void main(String[] args) {
    try {
      // Recherche du service distant
      MathService mathService = (MathService) Naming.lookup("rmi://10.10.0.163/MathService");

      Scanner scanner = new Scanner(System.in);
      boolean continuer = true;

      while (continuer) {
        // Afficher le menu
        System.out.println("\n--- Menu des Opérations Mathématiques ---");
        System.out.println("1. Calculer le PGCD");
        System.out.println("2. Calculer le PPCM");
        System.out.println("3. Décomposition en Facteurs Premiers");
        System.out.println("4. Quitter");
        System.out.print("Choisissez une option : ");

        int choix = scanner.nextInt();

        switch (choix) {
          case 1: // PGCD
            System.out.print("Entrez le premier nombre : ");
            int a1 = scanner.nextInt();
            System.out.print("Entrez le deuxième nombre : ");
            int b1 = scanner.nextInt();
            int pgcd = mathService.pgcd(a1, b1);
            System.out.println("PGCD de " + a1 + " et " + b1 + " : " + pgcd);
            break;

          case 2: // PPCM
            System.out.print("Entrez le premier nombre : ");
            int a2 = scanner.nextInt();
            System.out.print("Entrez le deuxième nombre : ");
            int b2 = scanner.nextInt();
            int ppcm = mathService.ppcm(a2, b2);
            System.out.println("PPCM de " + a2 + " et " + b2 + " : " + ppcm);
            break;

          case 3: // Décomposition en Facteurs Premiers
            System.out.print("Entrez un nombre : ");
            int n = scanner.nextInt();
            List<Integer> facteurs = mathService.facteursPremiers(n);
            System.out.println("Facteurs premiers de " + n + " : " + facteurs);
            break;

          case 4: // Quitter
            continuer = false;
            System.out.println("Au revoir !");
            break;

          default:
            System.out.println("Choix invalide. Veuillez réessayer.");
        }
      }

      scanner.close();
    } catch (Exception e) {
      System.err.println("Erreur client : " + e.getMessage());
      e.printStackTrace();
    }
  }
}
