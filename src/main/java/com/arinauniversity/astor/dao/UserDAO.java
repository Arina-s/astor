package com.arinauniversity.astor.dao;

import com.arinauniversity.astor.model.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO {

    private static int count = 5;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    @SneakyThrows
    public User getUserById(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM users WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class)
        )
                .stream()
                .findAny()
                .orElse(null);
    }

    @SneakyThrows
    public void save(User user) {
        jdbcTemplate.update(
                "INSERT INTO users VALUES(?, ?, ?, ?)", ++count, user.getName(), user.getAge(), user.getEmail()
        );
    }

    @SneakyThrows
    public void update(int id, User updatedUser) {
        jdbcTemplate.update(
                "UPDATE users SET name = ?, age = ?, email = ? WHERE id = ?",
                updatedUser.getName(), updatedUser.getAge(), updatedUser.getEmail(), id
        );
    }

    @SneakyThrows
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

}
