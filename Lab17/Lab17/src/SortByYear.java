// Name: Ariana Rocha
// AndrewID: afrocha
// JAVA Lab17

import java.util.Comparator;

public class SortByYear implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        // Compare movies by their year
        return Integer.compare(m1.getYear(), m2.getYear());
    }
}
