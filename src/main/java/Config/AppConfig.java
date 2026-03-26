package Config;

public class AppConfig {

    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    public static final String API_KEY = "Bearer ".concat(System.getenv("TMDB_API_KEY"));

}
