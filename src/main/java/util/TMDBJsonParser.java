package util;

import com.google.gson.Gson;
import model.Movie;
import model.MovieResponse;

import java.util.List;


public class TMDBJsonParser {
    public List<Movie> parse(String json) {
        Gson gson = new Gson();

        MovieResponse movies = gson.fromJson(json, MovieResponse.class);

        return movies.getResults();
    }
}
