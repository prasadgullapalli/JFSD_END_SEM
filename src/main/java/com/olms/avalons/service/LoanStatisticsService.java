package com.olms.avalons.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.repository.LoanInformationRepository;

@Service
public class LoanStatisticsService {

    @Autowired
    private LoanInformationRepository loanInformationRepository;

    public Map<String, Long> getLoanCountByStatus() {
        List<Object[]> rawData = loanInformationRepository.getLoanCountByStatus();
        Map<String, Long> loanStats = new HashMap<>();

        for (Object[] row : rawData) {
            String status = (String) row[0];
            Long count = ((Number) row[1]).longValue();
            loanStats.put(status, count);
        }
        return loanStats;
    }
}
