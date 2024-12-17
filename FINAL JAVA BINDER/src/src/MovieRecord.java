import java.io.BufferedReader;  // For reading data from streams
import java.io.IOException;    // For handling input/output exceptions
import java.io.InputStreamReader; // To convert InputStream to BufferedReader
import java.io.PrintWriter;    // For writing data to output streams
import java.net.*;             // For networking classes like Socket and ServerSocket
import java.util.*;            // For utility classes like ArrayList, Map, and PriorityQueue

// Class representing a movie record
public class MovieRecord {
    private String title;  // Title of the movie
    private String genre;  // Genre of the movie
    private int rating;    // Rating of the movie (1 to 10)

    // Constructor to initialize a MovieRecord object
    public MovieRecord(String title, String genre, int rating) {
        this.title = title;
        this.genre = genre;
        // Ensure the rating is within the valid range, otherwise default to 1
        if (rating >= 1 && rating <= 10) {
            this.rating = rating;
        } else {
            this.rating = 1;
        }
    }
    // Convert movie details into a CSV format (comma-separated values)
    public String toCSV() {
        return title + "," + genre + "," + rating;
    }

    // Static method to calculate the sum of ratings for movies of a specific genre
    public static int sumRatings(ArrayList<MovieRecord> movies, String genre) {
        int sum = 0;
        // Iterate over the list of movies
        for (MovieRecord movie : movies) {
            // Add the rating if the genre matches (ignoring case)
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                sum += movie.getRating();
            }
        }
        return sum; // Return the total sum of ratings
    }

    // Static method to send movie data to a server
    public static void sendMoviesToServer(ArrayList<MovieRecord> movies) throws IOException {
        // Establish a socket connection to the server on localhost at port 8080
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send each movie record in CSV format to the server
            for (MovieRecord movie : movies) {
                out.println(movie.toCSV());
            }
            // Indicate end of data with "Done"
            out.println("Done");
            // Read and print the server's response
            String response = in.readLine();
            System.out.println("Server response: " + response);
        }
    }

    // Static method to receive movie data from a client
    public static ArrayList<MovieRecord> receiveMoviesFromClient() throws IOException {
        ArrayList<MovieRecord> movieList = new ArrayList<>();

        // Set up a server socket to listen for client connections on port 8080
        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String input;
            // Read input from the client line by line
            while ((input = in.readLine()) != null) {
                // Stop reading if "Done" is received
                if ("Done".equalsIgnoreCase(input)) {
                    break;
                }
                // Split the CSV data and create a MovieRecord object
                String[] data = input.split(",");
                movieList.add(new MovieRecord(data[0], data[1], Integer.parseInt(data[2])));
            }
            // Send the size of the movie list back to the client
            out.println(movieList.size());
        }
        return movieList; // Return the list of received movies
    }

    // Static method to create a map of genres and their total ratings
    public static Map<String, Integer> genreMap(ArrayList<MovieRecord> movies) {
        Map<String, Integer> map = new HashMap<>();
        // Iterate over the list of movies
        for (MovieRecord movie : movies) {
            String genre = movie.getGenre();
            int rating = movie.getRating();

            // Update the total rating for the genre in the map
            if (map.containsKey(genre)) {
                map.put(genre, map.get(genre) + rating);
            } else {
                map.put(genre, rating); // Initialize the total rating for a new genre
            }
        }
        return map; // Return the genre-to-rating map
    }

    // Static method to create a priority queue of movies sorted by rating (highest first)
    public static PriorityQueue<MovieRecord> createPriorityQueue(ArrayList<MovieRecord> movies) {
        // Create a Comparator using an anonymous class to sort by rating in descending order
        PriorityQueue<MovieRecord> queue = new PriorityQueue<>(new Comparator<MovieRecord>() {
            @Override
            public int compare(MovieRecord a, MovieRecord b) {
                // Compare by rating in descending order
                return b.getRating() - a.getRating();
            }
        });
    
        // Add all movies to the priority queue
        int index = 0;
        while (index < movies.size() && movies.get(index) != null) {
            queue.add(movies.get(index));
            index++;
        }
    
        return queue; // Return the priority queue
    }

     // Getter for movie title
     public String getTitle() {return title;}
    // Setter for movie title
    public void setTitle(String title) {this.title = title;}

    // Getter for movie genre
    public String getGenre() {return genre;}
    // Setter for movie genre
    public void setGenre(String genre) {this.genre = genre;}

    // Getter for movie rating
    public int getRating() {return rating;}
    // Setter for movie rating
    public void setRating(int rating) {this.rating = rating;}
}