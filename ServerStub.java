// Import Statements
import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/*
The 'ServerStub' class encapsulates the server-side logic of the RMI system. It creates a
server socket, listens for incoming connections, and handles client requests. Upon receiving
a request, it reads a 'HeaderFile' containing method information and corresponding arguments.
Utilizing reflection, it locates and invokes the appropriate method on the local 'remoteObject'.
The server then sends the result back to the client. The class ensures efficient communication
between clients and the server.
*/

public class ServerStub {
    private final Object remoteObject;

    // Constructor: Initializes the ServerStub with a reference to the local remoteObject
    public ServerStub(Object remoteObject) {
        this.remoteObject = remoteObject;
    }

    // Method to start the server and handle client requests
    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running and ready to accept client requests on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                     ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

                    // Receiving the header file
                    HeaderFile headerFile = (HeaderFile) in.readObject();

                    // Receiving method arguments
                    Object[] args = (Object[]) in.readObject();

                    // Finding the method
                    Method method = findMatchingMethod(headerFile);

                    // Invoking the method
                    Object result = method.invoke(remoteObject, deserializeArguments(args));

                    // Sending the result
                    out.writeObject(result);

                } catch (Exception e) {
                    e.printStackTrace();
                    // Handle exceptions appropriately
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    // Method to find the matching method on the local 'remoteObject'
    private Method findMatchingMethod(HeaderFile headerFile) throws NoSuchMethodException {
        return remoteObject.getClass().getMethod(headerFile.getMethodName(), headerFile.getParameterTypes());
    }

    // Method to deserialize method arguments
    private Object[] deserializeArguments(Object[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Serializable) {
                args[i] = deepCopy(args[i]);
            }
        }
        return args;
    }

    // Method to create a deep copy of an object
    private Object deepCopy(Object original) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {

            out.writeObject(original);
            out.flush();

            try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()))) {
                return in.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
            return null;
        }
    }
}
