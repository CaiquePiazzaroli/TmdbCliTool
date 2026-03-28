package service;

import client.TmdbClient;
import model.Movie;
import util.TMDBJsonParser;

import java.util.List;

public class MovieService {

    private final TmdbClient client = new TmdbClient();

    public void getMovie(String type) {
        client.fetchMovies(type).ifPresentOrElse(
                moviesString -> {
                    List<Movie> moviesList = new TMDBJsonParser().parse(moviesString);
                    moviesList.forEach(m -> System.out.println(m.getTitle()));
                },
                () -> {
                    System.out.println("Error: Type is not a valid type: " + type);
                }
        );
    }
}
