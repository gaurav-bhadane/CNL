import java.io.*;
import java.net.*;

public class tcpserver {
    public static void main(String[] args) {
        try {
            // Step 1: Create a ServerSocket object and bind it to a port
            ServerSocket serverSocket = new ServerSocket(12345);

            System.out.println("Server is listening on port 12345...");

            // Step 2: Accept incoming client connections
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Step 3: Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Step 4: Read data from client and send response
            String clientMessage = in.readLine();
            System.out.println("Client says: " + clientMessage);

            out.println("Server received: " + clientMessage);

            // Step 5: Close streams and sockets
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}