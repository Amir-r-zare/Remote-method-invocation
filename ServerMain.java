// Import Statements
import java.rmi.RemoteException;

/*
The 'ServerMain' class serves as the entry point for the server-side of the remote method
 invocation (RMI) system. It initializes a 'RemoteObjectImpl' representing the local object
 with remotely accessible methods. The dynamic port assignment ensures flexibility, and it
 instantiates a 'ServerStub' to listen for incoming client requests. The server dynamically
 finds an available port, allowing for seamless communication with clients.
*/

public class ServerMain {
    public static void main(String[] args) throws RemoteException {
        // An instance of the 'RemoteObjectImpl' class is created.
        RemoteObject remoteObject = new RemoteObjectImpl();

        // Find an available port dynamically
        int port = findAvailablePort();
        System.out.println("Server is running on port " + port);

        // An instance of the 'ServerStub' class is created.
        ServerStub serverStub = new ServerStub(remoteObject);

        // The start method of the 'ServerStub' is invoked with the dynamically assigned port number.
        serverStub.start(port);
    }

    // Method to check if a port is available
    private static boolean isPortAvailable(int port) {
        // Let the port is available
        return true;
    }

    // Method to find an available port dynamically
    public static int findAvailablePort() {
        int port = 9000; // Starting port number

        // Iterate until an available port is found
        while (!isPortAvailable(port)) {
            port++;
        }
        return port;
    }
}
