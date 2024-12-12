import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class MathServiceImpl extends UnicastRemoteObject implements MathService {

  public MathServiceImpl() throws RemoteException {
    super();
  }

  // Calcul du PGCD
  @Override
  public int pgcd(int a, int b) throws RemoteException {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  // Calcul du PPCM
  @Override
  public int ppcm(int a, int b) throws RemoteException {
    return (a * b) / pgcd(a, b);
  }

  // Décomposition en facteurs premiers
  @Override
  public List<Integer> facteursPremiers(int n) throws RemoteException {
    List<Integer> facteurs = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      while (n % i == 0) {
        facteurs.add(i);
        n /= i;
      }
    }
    return facteurs;
  }
}
