package fr.fred.modele;

import fr.fred.beans.User;
import fr.fred.util.AnalyzeUriResource;
import fr.fred.util.WebUtil;
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

    /**
     * Recherche la liste de tous les utilisateurs
     * @return la liste de tous les utilisateurs
     */
    public Collection<User> getListOfUsers() {
        return Arrays.asList(restTemplate.getForObject(WebUtil.SERVICE_LOCATION + "/listOfUsers", User[].class));
    }

    /**
     * Retourne les détails d'un utilisateur
     * @param id de l'utilisateur dont l'on souhaite obtenir des détails
     * @return un utilisateur
     */
    public User getUser(long id) {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", id);
        return restTemplate.getForObject(WebUtil.SERVICE_LOCATION + "/user/{id}", User.class, parameters);
    }


}
