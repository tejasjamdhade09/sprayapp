/*package com.farm.controller;

import com.farm.entity.User;
import com.farm.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // 🟢 Show registration page
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // register.html
    }

    // 🟢 Handle registration form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        // Check if username/email already exists
        if (userService.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }
        if (userService.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "Email already registered!");
            return "register";
        }

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set default role for new users
        user.setRole("USER");

        // Save user to DB
        userService.saveUser(user);

        // Redirect to login with success message
        return "redirect:/login?success";
    }

    // 🟢 Show login page
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // login.html
    }

    // 🟢 After successful login, redirect based on role
    @GetMapping("/home")
    public String homePage() {
        // You can redirect based on role here
        return "home"; // main dashboard after login
    }

    // 🟢 Optional: Admin Dashboard
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin-dashboard"; // admin-dashboard.html
    }
}*/
