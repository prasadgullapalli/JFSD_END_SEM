package com.olms.avalons.controller;

import com.olms.avalons.repository.LoanInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/loans")
public class LoanViewController {

    @Autowired
    LoanInformationRepository loanInformationRepository;

    @GetMapping("/status-graph")
    public String showLoanStatusGraph(Model model) {
        // Fetch loan statuses and their counts
        List<Object[]> loanStatusData = loanInformationRepository.getLoanCountByStatus();
        Map<String, Long> statuses = new HashMap<>();

        for (Object[] data : loanStatusData) {
            String status = (String) data[0]; // "approved" or "declined"
            BigInteger countBigInt = (BigInteger) data[1];
            Long count = countBigInt.longValue();  // Convert BigInteger to Long
            statuses.put(status, count);
        }

        // Prepare the data for the charts
        List<String> statusList = List.copyOf(statuses.keySet());
        List<Long> countList = List.copyOf(statuses.values());

        model.addAttribute("statuses", statusList);
        model.addAttribute("counts", countList);

        return "loanStatusGraph";  // Referencing the JSP to render the charts
    }
}