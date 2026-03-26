import cli.CommandParser;
import client.TmdbClient;
import service.MovieService;

public class Main {
    public static void main(String[] args) {
        CommandParser parser = new CommandParser();
        String type = parser.getType(args);

        MovieService client = new MovieService();
        client.getMovie(type);
    }
}
