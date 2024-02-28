// Import Statements
import java.io.IOException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

/*
The 'Main' class represents the client-side of the RMI system. It initializes a 'RemoteObjectImpl' as
the local object with methods to be invoked remotely. The dynamic port assignment allows clients to
connect flexibly. It creates a 'ServerStub' and starts it on a dynamically assigned port. Additionally,
it establishes a 'ClientStub' to communicate with the server. The class exemplifies remote method
invocation by invoking the 'add' method on the server and printing the result.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        An instance of the RemoteObjectImpl class is created.
        This represents the local object whose methods can be invoked remotely.
        */
        RemoteObject remoteObject = new RemoteObjectImpl();

        /*
        A ServerStub is instantiated with the RemoteObject instance,
        and the start method is called to begin listening for client requests
        on the dynamically assigned port.
        */
        ServerStub serverStub = new ServerStub(remoteObject);

        // Dynamically get the server port from ServerMain
        int port = ServerMain.findAvailablePort();

        serverStub.start(port);

        // A ClientStub is created with the IP address of the server and the dynamically assigned port number.
        ClientStub clientStub = new ClientStub("172.23.153.16", port);

        // Example: Invoking the 'add' method remotely
        Method addMethod;
        try {
            /*
            The getMethod is used to obtain a Method object representing the
            'add' method of the RemoteObject interface.
            */
            addMethod = RemoteObject.class.getMethod("add", int.class, int.class);

            // Creating a HeaderFile instance
            HeaderFile headerFile = new HeaderFile("add", new Class<?>[]{int.class, int.class});

            // Sending the header file
            clientStub.sendHeaderFile(headerFile);

            /*
            The invoke method of the ClientStub is then called with the method and
            an array of arguments (in this case, two integers: 10 and 15).
            */
            Object result = clientStub.invoke(addMethod, new Object[]{10, 15});
            System.out.println("Result of add: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Similar invocations for other methods...
    }
}
