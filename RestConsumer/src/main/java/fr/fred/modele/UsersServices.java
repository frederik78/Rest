package fr.fred.modele;

import fr.fred.beans.User;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by Frederic on 28/12/13.
 */
public class UsersServices {
    private static final UsersServices USERS_SERVICES = new UsersServices();
    private RestTemplate restTemplate = new RestTemplate();

    private UsersServices() {
        // Nothing
    }

    public static UsersServices getService() {
        return USERS_SERVICES;
    }

    public Collection<User> getListOfUsers() {

        return Arrays.asList(restTemplate.getForObject("http://localhost:971/listOfUsers", User[].class));
    }

    public User getUser(long id)
    {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", id);
        return restTemplate.getForObject("http://localhost:971/user", User.class, parameters);
    }




}
