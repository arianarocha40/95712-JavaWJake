import java.io.BufferedReader;  // For reading data from streams
import java.io.IOException;    // For handling input/output exceptions
import java.io.InputStreamReader; // To convert InputStream to BufferedReader
import java.io.PrintWriter;    // For writing data to output streams
import java.net.ServerSocket;  // For creating a server socket to listen for incoming connections
import java.net.Socket;        // For managing client-server communication
import java.util.ArrayList;    // For using dynamic arrays

public class MovieServer {

    // This method listens for incoming client connections and receives movie data
    public static ArrayList<MovieRecord> receiveMoviesFromClient() throws IOException {
        // Create an empty list to store the received movie records
        ArrayList<MovieRecord> movieList = new ArrayList<>();

        // Using try-with-resources to automatically close resources after use
        try (ServerSocket serverSocket = new ServerSocket(8080);  // Server listens on port 8080
             Socket clientSocket = serverSocket.accept();  // Accepts a client connection
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  // Reads input from client
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {  // Sends output to client

            String input;
            // Continuously read input from the client until "Done" is received
            while ((input = in.readLine()) != null) {
                // If the client sends "Done", stop receiving data
                if ("Done".equalsIgnoreCase(input)) {
                    break;
                }
                // Split the input string into parts (assuming it's CSV format)
                String[] data = input.split(",");
                // Create a new MovieRecord using the parsed data and add it to the movie list
                movieList.add(new MovieRecord(data[0], data[1], Integer.parseInt(data[2])));
            }
            // Send the number of movies received back to the client
            out.println(movieList.size());
        }

        // Return the populated movie list
        return movieList;
    }
}