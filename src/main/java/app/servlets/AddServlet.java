package app.servlets;

import app.entities.User;
import app.model.Model;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("password");
        User newUser = new User(name,pass);
        Model model = Model.getInstance();
        if (model.addNewUser(newUser)) {
            resp.setStatus(HttpServletResponse.SC_OK);
            doGet(req, resp);
        }else {
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
            doGet(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/add.jsp");
        requestDispatcher.forward(req,resp);
    }
}
