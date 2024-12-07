package com.olms.avalons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoanInfoController {
  
	@GetMapping("/loan-info")
	public String loanInfoPage() {
        return "loan-emi"; // This will resolve to /WEB-INF/jsp/loan_info.jsp
    }
	
}
