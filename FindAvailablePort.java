import java.io.IOException;
import java.net.ServerSocket;

public class FindAvailablePort {

    public static void main(String[] args) {
        int port = findAvailablePort();
        System.out.println("Available port: " + port);
    }

    public static int findAvailablePort() {
        try (ServerSocket socket = new ServerSocket(0)) {
            return socket.getLocalPort();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
            return -1;
        }
    }
}
