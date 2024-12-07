package com.olms.avalons.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olms.avalons.service.LoanStatisticsService;

@RestController
@RequestMapping("/api/loans")
public class LoanStatisticsController {

    @Autowired
    private LoanStatisticsService loanStatisticsService;

    @GetMapping("/status-distribution")
    public ResponseEntity<Map<String, Long>> getLoanStatusDistribution() {
        return ResponseEntity.ok(loanStatisticsService.getLoanCountByStatus());
    }
}
