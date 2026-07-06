package com.example.demo.service;

import com.example.demo.requestdto.PricingRuleRequestDTO;
import com.example.demo.responsedto.PricingRuleResponseDTO;

import java.util.List;

public interface PricingRuleService {

    PricingRuleResponseDTO createRule(PricingRuleRequestDTO requestDTO);

    PricingRuleResponseDTO getRuleById(Long id);

    List<PricingRuleResponseDTO> getAllRules();

    PricingRuleResponseDTO updateRule(Long id, PricingRuleRequestDTO requestDTO);

    void deleteRule(Long id);
}