package com.olms.avalons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.olms.avalons.entity.CustomerEntity;
import com.olms.avalons.repository.CustomerRepository;
import com.olms.avalons.model.EmailManager;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailManager emailManager;

    @Autowired
    CustomerRepository customerRepository;

    // Method to show the email form with customer dropdown
    @GetMapping("/form")
    public String showEmailForm(Model model) {
        // Fetch all customers from the database
        List<CustomerEntity> customers = customerRepository.findAllCustomers();
        model.addAttribute("customers", customers);  // Pass customer list to the view
        return "emailForm"; // Corresponds to emailForm.jsp
    }

    // Method to send email
    @PostMapping("/send")
    public String sendEmail(
            @RequestParam("toemail") String toEmail,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            Model model) {
        
        String result = emailManager.sendEmail(toEmail, subject, message);
        model.addAttribute("result", result);
        return "result"; // Corresponds to result.jsp
    }
}
