// Name: Ariana Rocha
// AndrewID: afrocha
// JAVA Lab16

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Lab16Main {
	public ArrayList<Movie> movieList = new ArrayList<Movie>();
	private static Scanner keyboard = new Scanner(System.in);
    public static final int MOVIE_COUNT = 5; // Return this many movies in the searches
	
    /*
      Partially complete
      Add your code where needed
    */
	public static void main(String[] args) {
		Lab16Main lab16main = new Lab16Main();
		lab16main.readMovies("movies.tsv");

		Scanner keyboard = new Scanner(System.in);
		int choice;
		do {
			choice = getMenuChoice();
			switch (choice) {
                // case 1 sorts movies by ID
				case 1: lab16main.sortBy("ID");
					lab16main.displayMovies(lab16main.getList());
					break;
				// case 2 sorts movies by Name
				case 2:
                    lab16main.sortBy("Name");
                    lab16main.displayMovies(lab16main.getList());
					break;
				// case 3 sorts movies by Year
				case 3: 
                    lab16main.sortBy("Year");
					lab16main.displayMovies(lab16main.getList());
					break;
				// case 4 sorts movvies by Year and puts them in the reverse order
				case 4: 
					Comparator<Movie> reverseYearComparator = Collections.reverseOrder(new SortByYear());
					Collections.sort(lab16main.getList(), reverseYearComparator);
					lab16main.displayMovies(lab16main.getList());
					break;
				// case 5 searches movie list by name
				case 5:
					System.out.print("Enter the movie name: ");
                	String movieName = keyboard.nextLine();
                    ArrayList<Movie> searchResults = lab16main.searchByName(movieName);
					if (searchResults !=null && !searchResults.isEmpty()) {
						lab16main.displayMovies(searchResults);
					} else {
						System.out.println("No movies found by that name. Try again");
					}
					break;
				// case 6 searches movies by year
				case 6:
                    System.out.print("Enter the year the movie was made: ");
					int movieYear = keyboard.nextInt();
					keyboard.nextLine();
					ArrayList<Movie> searchResultsYear = lab16main.searchByYear(movieYear);
					if (searchResultsYear !=null && !searchResultsYear.isEmpty()) {
						lab16main.displayMovies(searchResultsYear);
					} else {
						System.out.println("No movies found made in that year. Try again");
					}
					break;
				// case 7 searches movies by genre
				case 7:
                    System.out.print("Enter the genre of the movie: ");
					String movieGenre = keyboard.nextLine();
					ArrayList<Movie> searchResultsGenre = lab16main.searchByGenre(movieGenre);
					if (searchResultsGenre !=null && !searchResultsGenre.isEmpty()) {
						lab16main.displayMovies(searchResultsGenre);
					} else {
						System.out.println("No movies found in that genre: ");
					}
					break;
				// quits 
				case 8: 
					System.out.println("Bye");
					break;
			}
		} while (choice != 8);
	}
	
    /*
       Don't change this method
    */
	public static int getMenuChoice() {
		System.out.println("1. Display by ID\n2. Display by name\n3. Display by year\n" + 
				"4. Display by year in reverse\n5. Search by name\n6. Search by year\n" +
				"7. Search by Genre\n8. Quit");
		System.out.print("Enter your choice: ");
		int choice = Integer.parseInt(keyboard.nextLine());
		if (choice < 1 || choice > 8) choice = 8;
		return choice;
	}
		
	public void readMovies(String filename) {
		Scanner fileInput = null;
		
		try {
			fileInput = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
        
		// While there are lines in the file
		while (fileInput.hasNextLine()) {
			// Read a line
			String line = fileInput.nextLine();
			// Split the line on the tab character (\t)
			String[] movieData = line.split("\t");
			// Create a Movie using toMovie method
			Movie movie = toMovie(movieData);
			// Add the movie to movieList
			movieList.add(movie);
		}
		// Close the scanner to avoid resource leaks
		fileInput.close();  
		
	}
	
	public Movie toMovie(String[] str) {
        /*  Returns one Movie from the data in str
            Each line of str should contain one field
            Change last one to ArrayList<String> for genres
        */
        int movieID = Integer.parseInt(str[0].strip());
		String movieName = str[1].strip().replace("\"", "");
		int year = Integer.parseInt(str[2].strip());
		String country = str[3].strip().replace("\"", "");
		ArrayList<String> genres = new ArrayList<String>();
        // Start at position #4
        // Strip and add to the ArrayList of genres
		for (int i=4; i<str.length; i++) {
			genres.add(str[i].strip());
		}
		return new Movie(movieID, movieName, year, country, genres);
	}
	
    // Don't change this, even if you don't like my table spacing
	private void displayMovies(ArrayList<Movie> list) {
		if (list.size() == 0) {
			System.out.println("Nothing to display");
		} else {
			System.out.format("%7s %50s %5s %30s %6s\n", "ID", "Name", "Year", "Country", "Genres");
			for (Movie m: list) {
				System.out.format("%7s %50s %5d %30s ", m.getMovieID(), m.getMovieName(), 
					m.getYear(), m.getCountry());
				for (int i=0; i<m.getGenres().size(); i++) {
					System.out.print(m.getGenres().get(i) + " ");
				}
				System.out.println();
			}
		}
		System.out.println();
	}
	
    // Sort according to the field indicated by s
	public void sortBy(String s) {
        switch (s) {
            case "ID":
                // Use Movie's built-in compareTo
                Collections.sort(movieList);
                break;
            case "Name":
				// Sort by movieName using a Comparator
				Collections.sort(movieList, new Comparator<Movie>() {
					@Override
					public int compare(Movie m1, Movie m2) {
						return m1.getMovieName().compareToIgnoreCase(m2.getMovieName());
					}
				});
				break;
            case "Year":
				// Sort by year using a Comparator
				Collections.sort(movieList, new Comparator<Movie>() {
					@Override
					public int compare(Movie m1, Movie m2) {
						return Integer.compare(m1.getYear(), m2.getYear());
					}
				});
				break;
            case "ReverseYear":
				// Sort by year in reverse order using reverseOrder() with a Comparator
				Collections.sort(movieList, Collections.reverseOrder(new Comparator<Movie>() {
					@Override
					public int compare(Movie m1, Movie m2) {
						return Integer.compare(m1.getYear(), m2.getYear());
					}
				}));
				break;
        }
	}
	
    // Search for MOVIE_COUNT movies by name
	public ArrayList<Movie> searchByName(String name) {
        // Sort by id before searches for consistent results
        sortBy("ID");

        // List of results
		ArrayList<Movie> list = new ArrayList<Movie>();

        // Count the # of matches
		int count = 0;
		for (Movie m: movieList) {
            // Does m match on the name key?
			if (m.getMovieName().equalsIgnoreCase(name)) {
                // Yes, so add it to the result list
				list.add(m);
				count++;

                // Quit if we hit the maximum # of movies to return
				if (count == Lab16Main.MOVIE_COUNT) break;
			}
		}
		return list;
	}
	
    // Search for MOVIE_COUNT movies by year
	public ArrayList<Movie> searchByYear(int year) {
		ArrayList<Movie> list = new ArrayList<Movie>();

        // Loop through the movieList and find matches
		for (Movie movie : movieList) {
			if (movie.getYear() == year) {
				list.add(movie);
			}
			// Stop if we reach MOVIE_COUNT matches
			if (list.size() >= MOVIE_COUNT) {
				break;
			}
		}

		return list; // Return the list of matching movies
	}
	
    // Search for MOVIE_COUNT movies by genre
	public ArrayList<Movie> searchByGenre(String genre) {
		ArrayList<Movie> list = new ArrayList<Movie>();

        // Loop through the movieList and find matches
		for (Movie movie : movieList) {
			for (String g : movie.getGenres()) {
				if (g.equalsIgnoreCase(genre.trim())) {  // Case-insensitive comparison
					list.add(movie);
					break;  // Move to the next movie after a match is found
				}
			}
			// Stop if we reach MOVIE_COUNT matches
			if (list.size() >= MOVIE_COUNT) {
				break;
			}
		}

		return list; // Return the list of matching movies
	}
	
    // Breaks encapsulation, boo!
	public ArrayList<Movie> getList() { return movieList; }

}
