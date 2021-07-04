package com.arinauniversity.astor.controller;

import com.arinauniversity.astor.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
