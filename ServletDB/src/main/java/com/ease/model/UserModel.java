package com.ease.model;

import com.ease.entity.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    public List<User> listUsers(DataSource dataSource) {
        List<User> listUsers = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            String query = "Select * from users";
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                listUsers.add(new User(resultSet.getInt("users_id"), resultSet.getString("users_name"), resultSet.getString("users_email")));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listUsers;
    }

    public void addUser(DataSource dataSource, User newUser) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            String username = newUser.getUsers_name();
            String email = newUser.getUsers_email();
            String query = "insert into users (users_name, users_email) values(?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


    public void updateUser(DataSource dataSource, User updatedUser) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();
            int usersId = updatedUser.getUsers_id();
            String username = updatedUser.getUsers_name();
            String email = updatedUser.getUsers_email();
            String query = "update users set users_name = ?, users_email = ? where users_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, usersId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(DataSource dataSource, int usersId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dataSource.getConnection();

            String query = "delete from users where users_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, usersId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
