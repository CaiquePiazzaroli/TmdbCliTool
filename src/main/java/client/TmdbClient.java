package client;

import Config.AppConfig;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TmdbClient {

    public String fetchMovies(String type) {

        String typeFormated = getTypeFormated(type);

        if(typeFormated == null) {
            System.out.println("The type " + type + " is not valid");
            return null;
        }

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest  request = HttpRequest.newBuilder()
                    .uri(URI.create(AppConfig.BASE_URL + typeFormated))
                    .GET()
                    .header("accept", "application/json")
                    .header("Authorization", AppConfig.API_KEY)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200) {
                return response.body();
            } else if(response.statusCode() == 404) {
                System.out.println("Error 404");
                return null;
            } else {
                System.out.println("Api error. HTTP code: " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
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
