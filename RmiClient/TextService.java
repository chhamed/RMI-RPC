import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextService extends Remote {
    int countOccurrences(String input, char character) throws RemoteException;
    boolean isPalindrome(String input) throws RemoteException;
}
