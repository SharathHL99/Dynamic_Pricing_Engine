package com.example.demo.controller;

import com.example.demo.requestdto.PricingRuleRequestDTO;
import com.example.demo.responsedto.PricingRuleResponseDTO;
import com.example.demo.service.PricingRuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing-rules")
@RequiredArgsConstructor
@Slf4j
public class PricingRuleController {

    private final PricingRuleService pricingRuleService;

    @PostMapping
    public ResponseEntity<PricingRuleResponseDTO> createRule(
            @Valid @RequestBody PricingRuleRequestDTO requestDTO) {

        log.info("Received request to create pricing rule: {}", requestDTO);

        PricingRuleResponseDTO response = pricingRuleService.createRule(requestDTO);

        log.info("Pricing rule created successfully with ID: {}", response.getId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PricingRuleResponseDTO> getRuleById(@PathVariable Long id) {

        log.info("Received request to fetch pricing rule with ID: {}", id);

        PricingRuleResponseDTO response = pricingRuleService.getRuleById(id);

        log.info("Successfully fetched pricing rule with ID: {}", id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PricingRuleResponseDTO>> getAllRules() {

        log.info("Received request to fetch all pricing rules");

        List<PricingRuleResponseDTO> rules = pricingRuleService.getAllRules();

        log.info("Successfully fetched {} pricing rules", rules.size());

        return ResponseEntity.ok(rules);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PricingRuleResponseDTO> updateRule(
            @PathVariable Long id,
            @Valid @RequestBody PricingRuleRequestDTO requestDTO) {

        log.info("Received request to update pricing rule with ID: {}", id);

        PricingRuleResponseDTO response = pricingRuleService.updateRule(id, requestDTO);

        log.info("Pricing rule updated successfully with ID: {}", id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRule(@PathVariable Long id) {

        log.info("Received request to delete pricing rule with ID: {}", id);

        pricingRuleService.deleteRule(id);

        log.info("Pricing rule deleted successfully with ID: {}", id);

        return ResponseEntity.ok("Pricing rule deleted successfully.");
    }
}
