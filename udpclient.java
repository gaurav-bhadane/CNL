import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpclient {
    public static void main(String[] args) {
        try {
            // Get the server's IP address
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Create a DatagramSocket for the client
            DatagramSocket clientSocket = new DatagramSocket();

            // Message to send
            String message = "Hello, UDP Server!";
            byte[] sendData = message.getBytes();

            // Create a DatagramPacket to send data to the server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 12345);

            // Send the packet to the server
            clientSocket.send(sendPacket);

            System.out.println("Message sent to server: " + message);

            // Close the client socket
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}