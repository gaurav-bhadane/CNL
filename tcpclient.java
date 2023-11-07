import java.io.*;
import java.net.*;

public class tcpclient {
    public static void main(String[] args) {
        try {
            // Step 1: Create a Socket object and connect to the server
            Socket cs = new Socket("localhost", 12345);

            // Step 2: Create input and output streams for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

            // Step 3: Send a message to the server
            out.println("Hello, Server!");

            // Step 4: Receive and print response from the server
            String serverResponse = in.readLine();
            System.out.println("Server response: " + serverResponse);

            // Step 5: Close streams and socket
            in.close();
            out.close();
            cs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}