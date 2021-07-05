package com.arinauniversity.astor.dao;

import com.arinauniversity.astor.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    private static int count;
    private final List<User> userList;

    {
        userList = new ArrayList<>();
        userList.add(new User(++count, "Mary"));
        userList.add(new User(++count, "Nikolas"));
        userList.add(new User(++count, "Simon"));
    }

    public List<User> getUsers() {
        return userList;
    }

    public User getUserById(int id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(User user) {
        user.setId(++count);
        userList.add(user);
    }

    public void update(int id, User updatedUser) {
        User user = getUserById(id);
        user.setName(updatedUser.getName());
    }

    public void delete(int id) {
        userList.removeIf(user -> user.getId() == id);
    }

}
