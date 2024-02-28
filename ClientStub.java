// Import Statements
import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;

/*
The 'ClientStub' class facilitates communication from the client to the server in the RMI system.
It sends a 'HeaderFile' containing method information and arguments to the server. The 'invoke'
method triggers the remote method invocation, and the 'sendHeaderFile' method sends the header file.
The class provides 'serialization' and deep copy functionality for method arguments, ensuring proper
communication with the server.
*/

public class ClientStub {
    private final String host;
    private final int port;

    // Define a constructor that initializes the 'ClientStub' with the server's host and port.
    public ClientStub(String host, int port) {
        this.host = host;
        this.port = port;
    }

    // Define a constructor that initializes the 'ClientStub' with the server's host and port.
    public Object invoke(Method method, Object[] args) {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            // Sending the header file
            HeaderFile headerFile = new HeaderFile(method.getName(), method.getParameterTypes());
            out.writeObject(headerFile);

            // Sending method arguments
            out.writeObject(serializeArguments(args));

            // Receiving the result
            return in.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately
            return null;
        }
    }

    // Declare a method 'sendHeaderFile' which is currently left as a placeholder.
    // This method can be implemented if additional functionality related to sending header files is needed.
    public void sendHeaderFile(HeaderFile headerFile) {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            // Open a new socket connection to the server
            // Create an ObjectOutputStream to send data to the server

            // Send the header file to the server
            out.writeObject(headerFile);

        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    // Define a private method 'serializeArguments' that takes an array of objects as arguments.
    // Iterate through the array and, if an object is serializable, perform a deep copy using the deepCopy method.
    private Object[] serializeArguments(Object[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Serializable) {
                args[i] = deepCopy(args[i]);
            }
        }
        return args;
    }

    /*
    Define a private method 'deepCopy' that creates a deep copy of a serializable object.
    Utilize 'ByteArrayOutputStream' and 'ObjectOutputStream' for serialization, and
    'ByteArrayInputStream' and 'ObjectInputStream' for deserialization.
    Handle exceptions, print the stack trace, and return null in case of errors.
    */
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
