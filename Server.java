//// Import Statements:
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//// Defines the 'Server' class.
///*
//    this is a test class for test it that client and server can connect together or not.
//    This class is independent from the 2nd part of the exercise and has nothing to do with it.
//*/
//public class Server {
//
//    public static void main(String[] args) {
//        // Specifies the port number on which the server will listen for incoming client requests.
//        int port = 9976;
//
//        //Creates a ServerSocket object and binds it to the specified port.
//        //The try-with-resources statement ensures that the ServerSocket is closed when done.
//        try (ServerSocket serverSocket = new ServerSocket(port)) {
//            System.out.println("Server is running and ready to accept client requests on port " + port);
//
//            while (true) {
//                // Accepts a client connection and initializes input and output streams for communication.
//                try (Socket clientSocket = serverSocket.accept();
//                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
//                     ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {
//
//                    // Reads a message from the client using the 'ObjectInputStream'.
//                    String message = (String) in.readObject();
//                    System.out.println("Received from client: " + message);
//
//                    // Process the input (you can add your logic here)
//                    String response = "Server processed: " + message;
//
//                    // Writes a response back to the client using the 'ObjectOutputStream'.
//                    out.writeObject(response);
//                    System.out.println("Sent to client: " + response);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
