package crudboot2.crudboot2.controller;

import crudboot2.crudboot2.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import crudboot2.crudboot2.service.UserService;

import java.util.List;

@Controller
public record UserController(UserService userService) {

    @GetMapping("/")
    public String index(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PutMapping(value = "/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") long id) {
        user.setId(id);
        userService.update(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }
}