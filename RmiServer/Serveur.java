import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
  public static void main(String[] args) {
    try {
      LocateRegistry.createRegistry(1099);
      TextService textService = new TextServiceImpl();
      Naming.rebind("rmi://10.10.0.163/TextService", textService);
      System.out.println("Serveur prêt !");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
