package fr.fred.servlet;

import fr.fred.beans.User;
import fr.fred.modele.UsersServices;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Frederic on 28/12/13.
 */
public class Users extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String path = StringUtils.delete(req.getRequestURL().getServletPath(), "/");
        if ("listOfUsers".equals(path)) {
            final Collection<User> users = UsersServices.getService().getListOfUsers();
            req.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/listOfUsers.jsp").forward(req, resp);
        }

    }

}
