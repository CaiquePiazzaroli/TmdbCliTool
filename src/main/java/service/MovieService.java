package service;

import client.TmdbClient;

public class MovieService {

    private final TmdbClient client = new TmdbClient();

    public void getMovie(String type) {
        String movies = client.fetchMovies(type);
        System.out.println(movies);

        // Imprime lista de filmes
    }
}
