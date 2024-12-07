package com.olms.avalons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class EmiCalculatorController {

    @GetMapping("/emi-calculator")
    public String calculateEmi(@RequestParam(required = false) Double principal, 
                               @RequestParam(required = false) Double rate, 
                               @RequestParam(required = false) Integer tenure, 
                               Model model) {
        if (principal != null && rate != null && tenure != null) {
            double monthlyRate = rate / (12 * 100); // Convert annual rate to monthly
            int months = tenure * 12; // Convert years to months
            double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                         (Math.pow(1 + monthlyRate, months) - 1);

            model.addAttribute("emi", emi);
        }
        return "emi-calculator"; // Name of the JSP or HTML page
    }
}
