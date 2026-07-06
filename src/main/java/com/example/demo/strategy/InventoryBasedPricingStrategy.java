package com.example.demo.strategy;

import com.example.demo.entity.PricingRule;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InventoryBasedPricingStrategy implements PricingStrategy {

    @Override
    public BigDecimal applyPrice(BigDecimal currentPrice,
                                 PricingRule pricingRule,
                                 Integer demand,
                                 Integer inventory,
                                 Integer hour) {

        if (inventory != null && inventory < 20) {

            BigDecimal percentage = pricingRule.getValue()
                    .divide(BigDecimal.valueOf(100));

            return currentPrice.add(currentPrice.multiply(percentage));
        }

        return currentPrice;
    }
}