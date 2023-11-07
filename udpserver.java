import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class udpserver {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket and bind it to a specific port
            DatagramSocket serverSocket = new DatagramSocket(12345);
            System.out.println("UDP Server is running...");

            byte[] receiveData = new byte[1024];

            while (true) {
                // Create a DatagramPacket to receive data from clients
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Receive data from client
                serverSocket.receive(receivePacket);

                // Convert the received data to a string
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Display the received message and client's address
                System.out.println("Received from client: " + message);
                System.out.println("Client IP: " + receivePacket.getAddress() + ", Port: " + receivePacket.getPort());

                // Clear the receive buffer
                receiveData = new byte[1024];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}