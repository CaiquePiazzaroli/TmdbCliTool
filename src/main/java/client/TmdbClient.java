package client;

import Config.AppConfig;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class TmdbClient {

    public Optional<String> fetchMovies(String type) {

        String typeFormated = getTypeFormated(type);
        final String URL = String.join("/", AppConfig.BASE_URL, typeFormated);
        final String API_KEY = AppConfig.API_KEY;

        if(typeFormated == null) {
            return Optional.empty();
        }

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest  request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .GET()
                    .header("accept", "application/json")
                    .header("Authorization", API_KEY)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200) {
                return Optional.of(response.body());
            } else if(response.statusCode() == 404) {
                return Optional.empty();
            } else {
                System.out.println("Api error. HTTP code: " + response.statusCode());
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private String getTypeFormated(String type) {
        return switch (type) {
            case "playing" -> "now_playing";
            case "popular" -> "popular";
            case "top" -> "top_rated";
            case "upcoming" -> "upcoming";
            default -> null;
        };
    }

}
