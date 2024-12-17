import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String address = "localhost";
        int port = 8001;

        // Parse address and port from arguments
        if (args.length == 2) {
            address = args[0];
            port = Integer.parseInt(args[1]);
        }

        System.out.println("Connecting to server at " + address + " on port " + port);
        Socket socket = new Socket(address, port);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your message: ");
            String message = scanner.nextLine();
            out.println(message);

            if (message.equalsIgnoreCase("QUIT")) {
                System.out.println("Exiting...");
                break;
            }

            String serverReply = in.readLine();
            System.out.println("Server: " + serverReply);

            if (serverReply.equalsIgnoreCase("QUIT")) {
                System.out.println("Server ended the connection.");
                break;
            }
        }
        scanner.close();
        socket.close();
        System.out.println("Connection closed.");
    }
}
