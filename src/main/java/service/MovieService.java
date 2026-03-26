package service;

import client.TmdbClient;
import model.Movie;
import util.TMDBJsonParser;

import java.util.List;

public class MovieService {

    private final TmdbClient client = new TmdbClient();

    public void getMovie(String type) {
        String moviesString = client.fetchMovies(type);
        TMDBJsonParser parser = new TMDBJsonParser();
        List<Movie> moviesList = parser.parse(moviesString);
        moviesList.forEach(movie -> System.out.println(movie.getTitle()));
    }
}
