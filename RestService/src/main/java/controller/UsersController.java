package controller;


import beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.UsersServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

@Controller
public class UsersController {

    @RequestMapping(value = "/users/user/{id}", method = RequestMethod.GET )
    public @ResponseBody User getUser(@PathVariable(value = "id") long id) throws Exception {
        return UsersServices.getService().getUser(id);

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    Collection<User> getListOfUsers() throws Exception {
        return UsersServices.getService().getListOfUsers();
    }

    @RequestMapping(value = "/users/new", method = RequestMethod.POST)
    public @ResponseBody User createUser(@RequestBody User user) throws Exception {
        return UsersServices.getService().createUser(user);
    }

}
