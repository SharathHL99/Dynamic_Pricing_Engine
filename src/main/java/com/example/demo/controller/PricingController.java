package com.example.demo.controller;

import com.example.demo.requestdto.DynamicPricingRequestDTO;
import com.example.demo.responsedto.DynamicPriceResponseDTO;
import com.example.demo.service.PricingService;
	import jakarta.validation.Valid;
	import lombok.RequiredArgsConstructor;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	@RestController
	@RequestMapping("/api/pricing")
	@RequiredArgsConstructor
	public class PricingController {

	    private final PricingService pricingService;

	    @PostMapping("/calculate")
	    public ResponseEntity<DynamicPriceResponseDTO> calculatePrice( @Valid @RequestBody DynamicPricingRequestDTO requestDTO) {

	        return ResponseEntity.ok(pricingService.calculatePrice(requestDTO));
	    }
	}


