import java.rmi.Naming;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    try {
      TextService textService = (TextService) Naming.lookup("rmi://10.10.0.163/TextService");
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.println("Menu :");
        System.out.println("1. Compter les occurrences d'un caractère.");
        System.out.println("2. Vérifier si une chaîne est un palindrome.");
        System.out.println("3. Quitter.");
        System.out.print("Votre choix : ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consommer le saut de ligne.

        if (choice == 3)
          break;

        System.out.print("Entrez une chaîne : ");
        String input = scanner.nextLine();

        switch (choice) {
          case 1:
            System.out.print("Entrez un caractère : ");
            char ch = scanner.nextLine().charAt(0);
            int count = textService.countOccurrences(input, ch);
            System.out.println("Nombre d'occurrences : " + count);
            break;

          case 2:
            boolean isPalindrome = textService.isPalindrome(input);
            System.out.println("Est-ce un palindrome ? " + isPalindrome);
            break;

          default:
            System.out.println("Choix invalide.");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
