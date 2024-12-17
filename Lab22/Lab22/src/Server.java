import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    private static boolean isRunning = true; // Flag to control server loop

    public static void main(String[] args) throws IOException {
        int port = 8001;

        // Parse port from arguments
        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        }

        System.out.println("Starting server on port: " + port);
        
        // Try-with-resources to automatically close the ServerSocket
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (isRunning) {
                System.out.println("Waiting for a client...");
                Socket clientConnection = serverSocket.accept(); // Accept a client connection
                System.out.println("Client connected: " + clientConnection.getInetAddress().getHostAddress());

                // Handle the client connection
                handleClient(clientConnection);
            }
        } catch (IOException e) {
            System.out.println("ServerSocket closed or encountered an error: " + e.getMessage());
        } finally {
            System.out.println("ServerSocket has been closed.");
        }

        System.out.println("Server shutdown.");
    }

    public static void handleClient(Socket clientConnection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
        PrintWriter out = new PrintWriter(clientConnection.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        String clientMessage;

        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Client: " + clientMessage);

            // Break the loop if client sends "QUIT"
            if (clientMessage.equalsIgnoreCase("QUIT")) {
                System.out.println("Client disconnected.");
                break;
            }

            // Prompt for server's reply
            System.out.print("Enter your reply: ");
            String serverReply = scanner.nextLine();
            out.println(serverReply); // Send reply to client

            // Check for server shutdown signal
            if (serverReply.equalsIgnoreCase("SHUTDOWN")) {
                System.out.println("Shutting down server...");
                isRunning = false; // Stop accepting new connections
                break;
            }
        }

        scanner.close(); // Close scanner
        clientConnection.close(); // Close client connection
        System.out.println("Connection closed.");
    }
}
