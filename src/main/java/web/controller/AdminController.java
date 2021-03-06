package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    @Autowired
    public void UserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String listUsers(ModelMap model) {
        model.addAttribute("listUsers", userService.getListUsers());
        model.addAttribute("allRoles", userService.getAllRoles());
        model.addAttribute("newUser", new User());
        return "admin";
    }

    @PostMapping("/editUser/{id}")
    public String editUser(ModelMap model, @PathVariable Long id) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("allRoles", userService.getAllRoles());
        return "editUser";
    }

    @PostMapping("/editUser")
    public String edit(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @PostMapping("/createUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
