//// Import Statements
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//
//// Defines the 'Client' class
//public class Client {
//
//    public static void main(String[] args) {
//        // Specifies the IP address and port number of the server to connect to.
//        String host = "172.23.153.16";
//        // Use the same port number as the server
//        int port = 9976;
//
//        /*
//        Creates a Socket object and initializes output and input streams
//        for communication with the server. The try-with-resources statement
//        ensures that the Socket is closed when done.
//        */
//        try (Socket socket = new Socket(host, port);
//             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
//
//            // Writes a message to the server using the 'ObjectOutputStream'.
//            String message = "Hello, server!";
//            out.writeObject(message);
//            System.out.println("Sent to server: " + message);
//
//            // Reads a response from the server using the 'ObjectInputStream' and prints it.
//            String response = (String) in.readObject();
//            System.out.println("Received from server: " + response);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
