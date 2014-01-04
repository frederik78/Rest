package fr.fred.servlet;

import fr.fred.beans.User;
import fr.fred.modele.UsersServices;
import fr.fred.util.AnalyzeUriResource;
import fr.fred.util.WebUtil;

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

        final AnalyzeUriResource resource = WebUtil.analyzeUriResource(req);
        if ("".equals(resource.getResource())) {
            final Collection<User> users = UsersServices.getService().getListOfUsers();
            req.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/listOfUsers.jsp").forward(req, resp);
        }

        if ("user".equals(resource.getResource())) {
            final User user = UsersServices.getService().getUser(resource.getId());
            req.setAttribute("user", user);
            req.setAttribute("disabled", "disabled");
            getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
        }

        if ("new".equals(resource.getResource())) {
            req.setAttribute("disabled", "");
            getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        final AnalyzeUriResource resource = WebUtil.analyzeUriResource(req);


    }


}
