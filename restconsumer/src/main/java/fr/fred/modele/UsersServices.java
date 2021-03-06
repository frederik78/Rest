package fr.fred.modele;

import fr.fred.beans.User;
import fr.fred.util.WebUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

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
     *
     * @return la liste de tous les utilisateurs
     */
    public Collection<User> getListOfUsers() {
        return Arrays.asList(restTemplate.getForObject(WebUtil.SERVICE_LOCATION + "/users", User[].class));
    }

    /**
     * Retourne les détails d'un utilisateur
     *
     * @param id de l'utilisateur dont l'on souhaite obtenir des détails
     * @return un utilisateur
     */
    public User getUser(long id) {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", id);
        return restTemplate.getForObject(WebUtil.SERVICE_LOCATION + "/users/user/{id}", User.class, parameters);
    }

    /**
     * Créé un nouvel utilisateur.
     * @param user qu'il faut créer
     * @return un utilisateur avec un identifiant
     */
    public User createUser(User user) {
        return restTemplate.postForObject(WebUtil.SERVICE_LOCATION + "/users/new", user, User.class);
    }

    /**
     * Met à jour un utilisateur
     * @param user qu'il faut mettre à jour
     */
    public void updateUser(User user)
    {
        restTemplate.put(WebUtil.SERVICE_LOCATION +"/users/user/{id}", user, user.getId());
    }

    /**
     * Suppression d'un utilisateur
     * @param id
     */
    public void delete(long id)
    {
        restTemplate.delete(WebUtil.SERVICE_LOCATION + "/users/user/{id}", id);
    }


}
