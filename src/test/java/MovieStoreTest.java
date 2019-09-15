import model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class MovieStoreTest {

    private final MovieStore movieStore = new MovieStore();
    private final Movie harryPotterMovie = new Movie("Harry Potter", "Rowling", 2000);
    private final Movie starWars = new Movie("Star Wars", "Shwimmer", 1999);
    private final Movie starTrek = new Movie("STAR Trek", "Shwimmer", 2002);
    private final Movie shawshankRedemption = new Movie("Shawshank Redemption", "Bob", 2001);
    private final Movie takeThat = new Movie("Take That", "Shwimmer", 2010);

    @Before
    public void setUp() throws Exception {
        movieStore.add(shawshankRedemption);
        movieStore.add(harryPotterMovie);
        movieStore.add(starWars);
        movieStore.add(starTrek);
        movieStore.add(takeThat);
    }

    @Test
    public void returnsNoResultsWhenNoTitlesPartiallyMatchSearch() throws Exception {
        MovieStore movieStore = new MovieStore();

        List<Movie> results = movieStore.findByPartialTitle("abc");

        assertThat(results.size(), is(0));
    }

    @Test
    public void findMoviesWhenTitlesArePartiallyMatchedCaseInsensitive() throws Exception {
        List<Movie> results = movieStore.findByPartialTitle("tar");

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starTrek, starWars));
    }

    @Test
    public void findMoviesWhenDirectorExactlyMatches() throws Exception {
        List<Movie> results = movieStore.findByDirector("Shwimmer");

        assertThat(results.size(), is(3));
        assertThat(results, containsInAnyOrder(starTrek, starWars, takeThat));
    }

    @Test
    public void findMoviesWhenReleaseYearIsBetweenTwoValues() throws Exception {
        List<Movie> results = movieStore.findByReleaseYear(1999, 2002);

        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(harryPotterMovie, shawshankRedemption));
    }

}