package com.example.demo.factory;

import com.example.demo.enums.PricingRuleType;
import com.example.demo.strategy.InventoryBasedPricingStrategy;
import com.example.demo.strategy.PricingStrategy;
import com.example.demo.strategy.SurgePricingStrategy;
import com.example.demo.strategy.TimeBasedPricingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PricingStrategyFactory {

    private final SurgePricingStrategy surgePricingStrategy;

    private final TimeBasedPricingStrategy timeBasedPricingStrategy;

    private final InventoryBasedPricingStrategy inventoryBasedPricingStrategy;

    public PricingStrategy getStrategy(PricingRuleType type) {

        switch (type) {

            case SURGE:
                return surgePricingStrategy;

            case TIME_BASED:
                return timeBasedPricingStrategy;

            case INVENTORY_BASED:
                return inventoryBasedPricingStrategy;

            default:
                throw new IllegalArgumentException("Invalid Pricing Rule");
        }
    }
}