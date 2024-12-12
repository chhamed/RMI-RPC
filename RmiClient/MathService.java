
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MathService extends Remote {
  int pgcd(int a, int b) throws RemoteException; // PGCD

  int ppcm(int a, int b) throws RemoteException; // PPCM

  List<Integer> facteursPremiers(int n) throws RemoteException; // Décomposition en facteurs premiers
}
