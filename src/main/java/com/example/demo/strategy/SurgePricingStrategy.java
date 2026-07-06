package com.example.demo.strategy;

import com.example.demo.entity.PricingRule;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SurgePricingStrategy implements PricingStrategy {

    @Override
    public BigDecimal applyPrice(BigDecimal currentPrice,
                                 PricingRule pricingRule,
                                 Integer demand,
                                 Integer inventory,
                                 Integer hour) {

        if (demand != null && demand > 100) {

            BigDecimal percentage = pricingRule.getValue()
                    .divide(BigDecimal.valueOf(100));

            return currentPrice.add(currentPrice.multiply(percentage));
        }

        return currentPrice;
    }
}