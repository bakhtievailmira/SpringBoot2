package com.example.springboot2.controller;

import com.example.springboot2.model.User;
import com.example.springboot2.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {


    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }


    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "new";
    }

    @PostMapping()
    public String creatUser(@ModelAttribute("user") User user) {
        userDao.save(user);
        return "redirect:/users";
    }

    @GetMapping()
    public String showUserList(Model model) {
        model.addAttribute("users", userDao.findAll());
        return "users";
    }
    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user",  userDao.findById(id));
        return "edit";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute ("user") User user){
        userDao.save(user);
        return  "redirect:/users";
    }



    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        userDao.deleteById(id);
        return "redirect:/users";
    }

}