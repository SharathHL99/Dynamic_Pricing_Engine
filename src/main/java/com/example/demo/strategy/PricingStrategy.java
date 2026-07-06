package com.example.demo.strategy;




import com.example.demo.entity.PricingRule;

	import java.math.BigDecimal;

	public interface PricingStrategy {

	    BigDecimal applyPrice(BigDecimal currentPrice,PricingRule pricingRule,Integer demand,Integer inventory,Integer hour);
	    
	}


