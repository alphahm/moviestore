package model;

public class Movie {
    private String movieTitle;
    private String director;
    private int releaseYear;

    public Movie(String movieTitle, String director, int releaseYear) {

        this.movieTitle = movieTitle;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String title() {
        return movieTitle;
    }

    public String director() {
        return director;
    }

    public int releaseYear() {
        return releaseYear;
    }
}
