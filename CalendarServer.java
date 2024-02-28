// import Statements
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
this CalendarServer class sets up an RMI server. It creates a remote object (EventCalendar),
binds it to the RMI registry, and prints a message indicating that the server is ready to
accept client requests. The server will listen for incoming client requests on the specified
port (default is 1099). Clients can then connect to this server, look up the remote object,
and invoke methods on it remotely.
*/

// Define CalendarServer Class
public class CalendarServer {
    // Main method
    public static void main(String[] args) {
        try {
            // An instance of the EventCalendar class is created.
            // This is the remote object that clients will interact with.
            EventCalendar calendar = new EventCalendar();

            // Bind the calendar object to the RMI registry
            // A local RMI registry is created on the default port 1099.
            // The registry is essential for binding and looking up remote objects.
            Registry registry = LocateRegistry.createRegistry(1099);

            // The EventCalendar object is bound to the RMI registry with the name "EventCalendar".
            // This makes it available for clients to look up.
            registry.rebind("EventCalendar", calendar);

            System.out.println("Server is running and ready to accept client requests.");

        // Handle RemoteException appropriately
        } catch (RemoteException e) {
            e.printStackTrace();

        }
    }
}
