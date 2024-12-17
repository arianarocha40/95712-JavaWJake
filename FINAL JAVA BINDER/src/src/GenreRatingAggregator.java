import java.io.BufferedReader;  // For reading data from streams
import java.io.IOException;    // For handling input/output exceptions
import java.io.InputStreamReader; // To convert InputStream to BufferedReader
import java.io.PrintWriter;    // For writing data to output streams
import java.net.ServerSocket;  // For creating a server socket to listen for incoming connections
import java.net.Socket;        // For managing client-server communication
import java.util.ArrayList;    // For using dynamic arrays

// GenreRatingAggregator class implements Runnable to allow multithreading
class GenreRatingAggregator implements Runnable {
    private final ArrayList<MovieRecord> movieList;  // List of movie records to process
    private final String genre;  // Genre to filter the movies
    private int totalRating;    // To store the total rating for the given genre

    // Constructor to initialize movie list and genre
    public GenreRatingAggregator(ArrayList<MovieRecord> movieList, String genre) {
        this.movieList = movieList;
        this.genre = genre;
        this.totalRating = 0;
    }

    // The method that runs in a separate thread to calculate total ratings for the given genre
    @Override
    public void run() {
        totalRating = 0;  // Reset totalRating before starting the calculation
        // Iterate over each movie in the list
        for (MovieRecord movie : movieList) {
            // If the movie's genre matches the specified genre, add its rating to the total
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                totalRating += movie.getRating();
            }
        }
    }

    // Getter for totalRating to access the result after thread completion
    public int getTotalRating() {
        return totalRating;
    }

    // Static method to receive movie data from the client over a socket connection
    public static ArrayList<MovieRecord> receiveMoviesFromClient() throws IOException {
        ArrayList<MovieRecord> movieList = new ArrayList<>();

        // Set up the server socket to listen on port 8080
        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket clientSocket = serverSocket.accept(); // Accept a client connection
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String input;
            // Continuously read the input from the client until "Done" is received
            while ((input = in.readLine()) != null) {
                if ("Done".equalsIgnoreCase(input)) {
                    break; // Stop reading if "Done" is received
                }
                // Split the received input (CSV format) and create a MovieRecord
                String[] data = input.split(",");
                movieList.add(new MovieRecord(data[0], data[1], Integer.parseInt(data[2])));
            }
            // Send the size of the movie list back to the client
            out.println(movieList.size());
        }
        return movieList; // Return the list of movies received from the client
    }



    // Main method to test the functionality
    public static void main(String[] args) throws InterruptedException {
        // Create a list of sample movies
        ArrayList<MovieRecord> movies = new ArrayList<>();
        movies.add(new MovieRecord("Movie1", "Action", 8));  // Movie1 with Action genre and 8 rating
        movies.add(new MovieRecord("Movie2", "Drama", 7));   // Movie2 with Drama genre and 7 rating
        movies.add(new MovieRecord("Movie3", "Action", 9));   // Movie3 with Action genre and 9 rating
        movies.add(new MovieRecord("Movie4", "Comedy", 6));   // Movie4 with Comedy genre and 6 rating

        // Create two GenreRatingAggregator tasks for "Action" and "Drama" genres
        GenreRatingAggregator actionAggregator = new GenreRatingAggregator(movies, "Action");
        GenreRatingAggregator dramaAggregator = new GenreRatingAggregator(movies, "Drama");

        // Create threads to run each task in parallel
        Thread actionThread = new Thread(actionAggregator);
        Thread dramaThread = new Thread(dramaAggregator);

        // Start both threads
        actionThread.start();
        dramaThread.start();

        // Wait for both threads to finish processing
        actionThread.join();
        dramaThread.join();

        // Print the total ratings for the Action and Drama genres
        System.out.println("Total Action Ratings: " + actionAggregator.getTotalRating());
        System.out.println("Total Drama Ratings: " + dramaAggregator.getTotalRating());
    }
}