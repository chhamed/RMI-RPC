import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MathServeur {
  public static void main(String[] args) {
    try {
      // Créer une instance du service
      MathServiceImpl mathService = new MathServiceImpl();

      // Lancer le registre RMI
      LocateRegistry.createRegistry(1099);

      // Enregistrer le service sous un nom
      Naming.rebind("rmi://10.10.0.163/MathService", mathService);

      System.out.println("MathServeur est prêt !");
    } catch (Exception e) {
      System.err.println("Erreur sur le serveur : " + e.getMessage());
      e.printStackTrace();
    }
  }
}
