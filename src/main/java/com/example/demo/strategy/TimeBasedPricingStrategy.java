package com.example.demo.strategy;

import com.example.demo.entity.PricingRule;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TimeBasedPricingStrategy implements PricingStrategy {

    @Override
    public BigDecimal applyPrice(BigDecimal currentPrice,
                                 PricingRule pricingRule,
                                 Integer demand,
                                 Integer inventory,
                                 Integer hour) {

        if (hour != null && hour >= 18 && hour <= 22) {

            BigDecimal percentage = pricingRule.getValue()
                    .divide(BigDecimal.valueOf(100));

            return currentPrice.add(currentPrice.multiply(percentage));
        }

        return currentPrice;
    }
}