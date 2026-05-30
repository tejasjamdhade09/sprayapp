package com.farm.controller;

import com.farm.entity.Crop;
import com.farm.entity.Plot;
import com.farm.entity.Pesticide;
import com.farm.entity.SprayRecord;
import com.farm.entity.User;
import com.farm.repository.CropRepository;
import com.farm.repository.PlotRepository;
import com.farm.repository.PesticideRepository;
import com.farm.repository.SprayRecordRepository;
import com.farm.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired private CropRepository cropRepository;
    @Autowired private PlotRepository plotRepository;
    @Autowired private PesticideRepository pesticideRepository;
    @Autowired private SprayRecordRepository sprayRecordRepository;
    @Autowired private UserRepository userRepository;

    // 🟢 Main Dashboard (accessible to logged-in users)
    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {

        // 🧩 Get logged-in username
        String username = authentication.getName();
        User loggedInUser = userRepository.findByUsername(username);

        // 🧩 Load all farm data
        List<Crop> crops = cropRepository.findAll();
        List<Plot> plots = plotRepository.findAll();
        List<Pesticide> pesticides = pesticideRepository.findAll();
        List<SprayRecord> sprayRecords = sprayRecordRepository.findAll();

        // 🧩 Add data to model for Thymeleaf
        model.addAttribute("username", loggedInUser.getFullname());
        model.addAttribute("role", loggedInUser.getRole());
        model.addAttribute("crops", crops);
        model.addAttribute("plots", plots);
        model.addAttribute("pesticides", pesticides);
        model.addAttribute("sprayRecords", sprayRecords);
        model.addAttribute("pageTitle", "Farm Dashboard");

        return "dashboard"; // dashboard.html
    }

    @PostMapping("/admin/changeRole")
    public String changeUserRole(@RequestParam Long id, @RequestParam String newRole) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setRole(newRole);
            userRepository.save(user);
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/admin/deleteUser")
    public String deleteUser(@RequestParam Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/dashboard";
    }

    // 🟢 Admin-only dashboard
    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("pageTitle", "Admin Dashboard");
        return "admin-dashboard"; // admin-dashboard.html
    }
    
    
}
