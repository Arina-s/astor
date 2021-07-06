package com.arinauniversity.astor.controller;

import com.arinauniversity.astor.dao.UserDAO;
import com.arinauniversity.astor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private static final String REDIRECT_USERS = "redirect:/users";
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
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.getUserById(id));
        return "users/user";
    }

    @GetMapping("/new")
    public String createForm(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userDAO.save(user);
        return REDIRECT_USERS;
    }

    @GetMapping("/{id}/edit")
    public String editForm(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDAO.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                           @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userDAO.update(id, user);
        return REDIRECT_USERS;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userDAO.delete(id);
        return REDIRECT_USERS;
    }

}
