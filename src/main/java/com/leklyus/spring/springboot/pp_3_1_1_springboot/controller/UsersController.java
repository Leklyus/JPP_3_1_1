package com.leklyus.spring.springboot.pp_3_1_1_springboot.controller;

import com.leklyus.spring.springboot.pp_3_1_1_springboot.models.User;
import com.leklyus.spring.springboot.pp_3_1_1_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "index";
    }

    @GetMapping(value = "/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "/edit";
    }

    @PatchMapping("/edit")
    public String update(@RequestParam(value = "id") Long id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:/";

    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") Long id) {

        userService.deleteUser(id);
        return "redirect:/";
    }
}
