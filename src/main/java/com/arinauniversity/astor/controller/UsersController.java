package com.arinauniversity.astor.controller;

import com.arinauniversity.astor.dao.UserDAO;
import com.arinauniversity.astor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userDAO.getUsers());
        return "users/users";
    }

    @GetMapping("/{id}")
    public String getUsers(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.getUserById(id));
        return "users/user";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userDAO.save(user);
        return "redirect:/users";
    }

}
