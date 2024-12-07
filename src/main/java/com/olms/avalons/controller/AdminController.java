package com.olms.avalons.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // Admin login page
    @GetMapping("/display")
    public String showLoginPage() {
        return "admin-login"; // Renders admin-login.jsp
    }

    // Admin authentication
    @PostMapping("/authenticate")
    public String authenticateAdmin(
        @RequestParam String username, 
        @RequestParam String password, 
        Model model
    ) {
        // Hardcoded credentials
        String adminUsername = "admin";
        String adminPassword = "admin";

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            // Redirect to admin dashboard on successful login
            return "redirect:/admin/dashboard";
        } else {
            // Show error message and stay on login page
            model.addAttribute("error", "Invalid credentials! Please try again.");
            return "admin-login";
        }
    }

    // Admin dashboard
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "admin-dashboard"; // Renders admin-dashboard.jsp
    }
}
