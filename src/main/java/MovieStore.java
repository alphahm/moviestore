import model.Movie;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class MovieStore {

    List<Movie> movies = new LinkedList<Movie>();

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findByPartialTitle(final String partialTitle) {
        return findBy(movie -> movie.title().toUpperCase().contains(partialTitle.toUpperCase()));
    }

    public List<Movie> findByDirector(final String director) {
        return findBy(movie -> movie.director().contains(director));
    }

    public List<Movie> findByReleaseYear(final int from, final int to) {
        return findBy(movie -> movie.releaseYear() > from && movie.releaseYear() < to);
    }

    private List<Movie> findBy(Predicate predicate) {
        List<Movie> results = new LinkedList<Movie>();

        for (Movie movie : movies) {
            if (predicate.matches(movie)) {
                results.add(movie);
            }
        }

        return results;
    }

    interface Predicate {
        boolean matches(Movie movie);
    }
}
