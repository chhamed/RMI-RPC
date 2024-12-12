import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class TextServiceImpl extends UnicastRemoteObject implements TextService {
  public TextServiceImpl() throws RemoteException {
    super();
  }

  @Override
  public int countOccurrences(String input, char character) {
    return (int) input.chars().filter(ch -> ch == character).count();
  }

  @Override
  public boolean isPalindrome(String input) {
    String reversed = new StringBuilder(input).reverse().toString();
    return input.equalsIgnoreCase(reversed);
  }
}
