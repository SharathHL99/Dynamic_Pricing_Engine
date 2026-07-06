package com.example.demo.service;

import com.example.demo.requestdto.DynamicPricingRequestDTO;
import com.example.demo.responsedto.DynamicPriceResponseDTO;

public interface PricingService {

    DynamicPriceResponseDTO calculatePrice(DynamicPricingRequestDTO requestDTO);

}