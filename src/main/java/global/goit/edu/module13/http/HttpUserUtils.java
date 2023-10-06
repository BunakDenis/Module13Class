package global.goit.edu.module13.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class HttpUserUtils {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();
    public static <T> List<T> sendGet(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        Type type = TypeToken.getParameterized(ArrayList.class, User.class).getType();
        List<T> result = GSON.fromJson(response.body(), type);
        for (T user : result) {
            System.out.println(user);
        }
        return result;
    }
    public static User sendPost (URI uri, User value) throws IOException, InterruptedException {
        final String requestBody = GSON.toJson(value);
        System.out.println(requestBody);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        User result = GSON.fromJson(response.body(), User.class);

        return result;
    }
    public static User getUserById(String uri, int id) throws IOException, InterruptedException, URISyntaxException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d", uri, id)))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return GSON.fromJson(response.body(), User.class);

    }
    public static List<User> getUserByName (String uri, String name) throws IOException, InterruptedException, URISyntaxException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", uri, name)))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        Type type = TypeToken.getParameterized(ArrayList.class, User.class).getType();

        return GSON.fromJson(response.body(), type);
    }
    public static void deleteUserById(String uri, User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d", uri, user.getId())))
                .DELETE()
                .build();
        HttpResponse<String> result = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Code of deleting user = " + result.statusCode());
    }
    public static User updateUserById(String uri, User user, int id) throws IOException, InterruptedException {
        user.setId(id);
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d", uri, id)))
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .header("Content-type", "application/json")
                .build();

        HttpResponse<String> result = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Code of updating user = " + result.statusCode());

        return GSON.fromJson(result.body(), User.class);
    }
}