package com.example.demo.controller;


import com.example.demo.requestdto.PricingRuleRequestDTO;
import com.example.demo.responsedto.PricingRuleResponseDTO;
import com.example.demo.service.PricingRuleService;
	import jakarta.validation.Valid;
	import lombok.RequiredArgsConstructor;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/api/pricing-rules")
	@RequiredArgsConstructor
	public class PricingRuleController {

	    private final PricingRuleService pricingRuleService;

	    @PostMapping
	    public ResponseEntity<PricingRuleResponseDTO> createRule( @Valid @RequestBody PricingRuleRequestDTO requestDTO) {

	        return new ResponseEntity<>( pricingRuleService.createRule(requestDTO),
	                HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<PricingRuleResponseDTO> getRuleById(@PathVariable Long id) {

	        return ResponseEntity.ok(pricingRuleService.getRuleById(id));
	    }

	    @GetMapping
	    public ResponseEntity<List<PricingRuleResponseDTO>> getAllRules() {

	        return ResponseEntity.ok(pricingRuleService.getAllRules());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<PricingRuleResponseDTO> updateRule(
	            @PathVariable Long id,
	            @Valid @RequestBody PricingRuleRequestDTO requestDTO) {

	        return ResponseEntity.ok(pricingRuleService.updateRule(id, requestDTO));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteRule(@PathVariable Long id) {

	        pricingRuleService.deleteRule(id);
	        return ResponseEntity.ok("Pricing rule deleted successfully.");
	    }
	}


