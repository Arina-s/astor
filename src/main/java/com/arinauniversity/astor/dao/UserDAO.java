package com.arinauniversity.astor.dao;

import com.arinauniversity.astor.model.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    private static final String URL = "jdbc:postgresql://localhost:5433/astor";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";
    private static int count = 5;
    private List<User> userList;
    private Connection connection;

    public UserDAO() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getUsers() {
        userList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userList;
    }

    public User getUserById(int id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(User user) {
        try {
            Statement statement = connection.createStatement();
            String SQL = String.format("INSERT INTO users VALUES(%s, '%s', %s, '%s')", ++count, user.getName(),
                    user.getAge(), user.getEmail());
            statement.executeQuery(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void update(int id, User updatedUser) {
        User user = getUserById(id);
        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());
        user.setEmail(updatedUser.getEmail());
    }

    public void delete(int id) {
        userList.removeIf(user -> user.getId() == id);
    }

}
