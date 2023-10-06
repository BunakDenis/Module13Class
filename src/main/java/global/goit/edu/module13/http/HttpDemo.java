package global.goit.edu.module13.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.List;

public class HttpDemo {

    private static final String GET_USER_BY_ID = "https://jsonplaceholder.typicode.com/users/";
    private static final String GET_USER_BY_NAME = "https://jsonplaceholder.typicode.com/users/?username=";
    private static final String DELETE_USER_URI = "https://jsonplaceholder.typicode.com/users/";
    private static final String UPDATE_USER_URI = "https://jsonplaceholder.typicode.com/users/";

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        URI uri = new URI("https://jsonplaceholder.typicode.com/users");

        HttpUserUtils httpUserUtils = new HttpUserUtils();

        List<User> users = HttpUserUtils.sendGet(uri);



        //Task 1.2
        //Create new User
        UserGoePosition geo = new UserGoePosition(1.55, 2.11);
        UserAddress address = new UserAddress("Vozdvizhenskay", "Apt.6", "Chernigiv", "16000", geo);
        UserCompany company = new UserCompany("FOP", "Survear", "Hello World");
        User userDenis = new User(1, "Denis", "xisi926@gmail.com", address, "0664988869", "goit.com", company);

        System.out.println(userDenis);

        User createdUser = HttpUserUtils.sendPost(uri, userDenis);

        System.out.println(createdUser);

        //Task Get Information of Id
        User userOfId = HttpUserUtils.getUserById(GET_USER_BY_ID, 7);
        System.out.println(userOfId);

        //Task get user by name
        List <User> listSearchingByName = HttpUserUtils.getUserByName(GET_USER_BY_NAME, "Antonette");
        for (User user : listSearchingByName) {
            System.out.println(user);
        }

        //Task Delete User
        HttpUserUtils.deleteUserById(DELETE_USER_URI, userOfId);

        //Task Update User
        User updatedUser = HttpUserUtils.updateUserById(UPDATE_USER_URI, userDenis, userOfId.getId());
        System.out.println(updatedUser);

    }
}