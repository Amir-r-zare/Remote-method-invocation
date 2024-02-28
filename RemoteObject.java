import java.rmi.Remote;
import java.rmi.RemoteException;

/*
The interface declares several methods, each of which is
intended to be invoked remotely. Each method includes a
throws RemoteException clause, indicating that it may throw a
RemoteException due to the nature of remote communication.
*/

public interface RemoteObject extends Remote {
    // Takes two integers as parameters (a and b) and returns an integer.
    int add(int a, int b) throws RemoteException;

    // Takes two strings and returns a boolean.
    boolean isEqual(String str1, String str2) throws RemoteException;

    // Takes a string and returns a character.
    char getFirstChar(String str) throws RemoteException;

    // Takes two doubles and returns a double
    double multiply(double x, double y) throws RemoteException;
}
