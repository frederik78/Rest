package controller;


import beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.UsersServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

@Controller
public class UsersController {

    @RequestMapping("/user")
    public @ResponseBody User getUser(@RequestParam(value = "id", required = true) long id) throws Exception {
        return UsersServices.getService().getUser(id);

    }

    @RequestMapping("/listOfUsers")
    public @ResponseBody
    Collection<User> getListOfUsers() throws Exception {
        return UsersServices.getService().getListOfUsers();
    }


}
