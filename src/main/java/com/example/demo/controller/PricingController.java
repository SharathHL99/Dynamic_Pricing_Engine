package com.example.demo.controller;

import com.example.demo.requestdto.DynamicPricingRequestDTO;
import com.example.demo.responsedto.DynamicPriceResponseDTO;
import com.example.demo.service.PricingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pricing")
@RequiredArgsConstructor
@Slf4j
public class PricingController {

    private final PricingService pricingService;

    @PostMapping("/calculate")
    public ResponseEntity<DynamicPriceResponseDTO> calculatePrice(
            @Valid @RequestBody DynamicPricingRequestDTO requestDTO) {

        log.info("Received request to calculate dynamic price: {}", requestDTO);

        DynamicPriceResponseDTO response = pricingService.calculatePrice(requestDTO);

        log.info("Price calculated successfully. Final Price: {}", response.getFinalPrice());

        return ResponseEntity.ok(response);
    }
}
