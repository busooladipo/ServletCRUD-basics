package com.ease.servletdb;

import com.ease.entity.User;
import com.ease.model.UserModel;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "homepage", value = "/operation")
public class OperationController extends HttpServlet {

    private static final long SerialVersionUID = 1L;
    @Resource(name = "jdbc/project")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String page = request.getParameter("page");
        page = page.toLowerCase();

        switch (page) {
            case "listusers":
                listUsers(request, response);
                break;
            case "adduser":
                addUserFormLoader(request, response);
                break;
            case "updateuser":
                updateUserFormLoader(request, response);
                break;
            case "deleteuser":
                deleteUser(Integer.parseInt(request.getParameter("usersId")));
                listUsers(request, response);
                break;
            default:
                error(request, response);
        }
    }

    private void deleteUser(int usersId) {
        new UserModel().deleteUser(dataSource, usersId);
    }

    private void updateUserFormLoader(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.getRequestDispatcher("updateUser.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("form");
        operation = operation.toLowerCase();

        switch (operation) {
            case "adduser":
                User newUser = new User(request.getParameter("username"), request.getParameter("email"));
                addUserOperation(newUser);
                listUsers(request, response);
                break;
            case "updateuser":
                User updatedUser = new User(Integer.parseInt(request.getParameter("usersId")), request.getParameter("username"), request.getParameter("email"));
                updateUserOperation(dataSource, updatedUser);
                listUsers(request, response);
                break;
            default:
                error(request, response);
        }

    }

    private void updateUserOperation(DataSource dataSource, User updatedUser) {
        new UserModel().updateUser(dataSource, updatedUser);
    }

    private void addUserOperation(User newUser) {
        new UserModel().addUser(dataSource, newUser);
    }

    public void listUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> listUsers;
        listUsers = new UserModel().listUsers(dataSource);
        request.setAttribute("listUsers", listUsers);
        request.getRequestDispatcher("listUser.jsp").forward(request, response);
    }

    public void addUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("addUser.jsp").forward(request, response);
    }

    public void error(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("error.jsp").forward(request, response);
    }

}