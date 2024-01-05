package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AuthController {
    private final UserService service;
    private final RoleService roleService;

    @Autowired
    public AuthController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping
    public String printAll(Model model) {
        model.addAttribute("users", service.getAllUsers());
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping("/")
    public String add(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin";
        }
        service.save(user);
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String remove(@RequestParam("id") Long id) {
        service.removeUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/edit")
    public String printEditForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("user") User user, BindingResult bindingResult,
                       @RequestParam("id") Long id) {
        if (!bindingResult.hasErrors()) {
            service.updateUser(user, id);
        }
        return "redirect:/admin";
    }
}