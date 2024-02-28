// import Statements
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
The 'RemoteObjectImpl' class implements the RemoteObject interface, defining the actual behavior of
remote methods. It serves as the server's local object, providing functionality for methods like
addition, string comparison, and character extraction. Instantiated in the ServerMain class, it
represents the object whose methods can be invoked remotely by clients.
*/

// RemoteObjectImpl class that implements the RemoteObject interface
public class RemoteObjectImpl extends UnicastRemoteObject implements RemoteObject {

    // Constructor
    public RemoteObjectImpl() throws RemoteException {
        // Call to the superclass constructor (UnicastRemoteObject)
        super();
    }

    // Implementation of the add method
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    // Implementation of the isEqual method
    @Override
    public boolean isEqual(String str1, String str2) throws RemoteException {
        return str1.equals(str2);
    }

    // Implementation of the getFirstChar method
    @Override
    public char getFirstChar(String str) throws RemoteException {
        return str.charAt(0);
    }

    // Implementation of the multiply method
    @Override
    public double multiply(double x, double y) throws RemoteException {
        return x * y;
    }

}
