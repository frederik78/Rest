package services;

import beans.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Frederic on 28/12/13.
 */
public class UsersServices {

    /**
     * Gestion des id
     */
    private static AtomicLong id = new AtomicLong(1);


    private static UsersServices usersServices  = new UsersServices();

    protected static Map<Long, User> result = new HashMap<Long, User>();


    public static UsersServices getService() throws Exception {
        if(result.isEmpty())
        {
            generateUsers();
        }
        return usersServices;
    }

    public User getUser(long id)
    {
        return result.get(id);
    }

    public Set<User> getListOfUsers()
    {
        return new HashSet<User>(result.values());
    }

    public User createUser(User user)
    {
        user.setId(id.getAndIncrement());
        result.put(user.getId(), user);
        return user;
    }


    private static void generateUsers() throws ParseException {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        final User user1 = new User();
        user1.setFirstname("Dali");
        user1.setLastname("Salvador");
        user1.setBirthday(simpleDateFormat.parse("11/05/1904"));
        user1.setPhone("01 23 45 67 89");
        user1.setEmail("salvador.dali@gmail.com");
        user1.setId(id.getAndIncrement());
        result.put(user1.getId(), user1);

        final User user2 = new User();
        user2.setFirstname("Freud");
        user2.setLastname("Sigmund");
        user2.setBirthday(simpleDateFormat.parse("06/05/1856"));
        user2.setPhone("01 23 45 67 89");
        user2.setEmail("sigmund.freud@gmail.com");
        user2.setId(id.getAndIncrement());
        result.put(user2.getId(), user2);

        final User user3 = new User();
        user3.setFirstname("Curie");
        user3.setLastname("Marie");
        user3.setBirthday(simpleDateFormat.parse("07/11/1867"));
        user3.setPhone("01 23 45 67 89");
        user3.setEmail("marie.curie@gmail.com");
        user3.setId(id.getAndIncrement());
        result.put(user3.getId(), user3);

        final User user4 = new User();
        user4.setFirstname("Newton");
        user4.setLastname("Isaac");
        user4.setBirthday(simpleDateFormat.parse("04/01/1643"));
        user4.setPhone("01 23 45 67 89");
        user4.setEmail("isaac.newton@gmail.com");
        user4.setId(id.getAndIncrement());
        result.put(user4.getId(), user4);
    }

}
