package com.example.demo.responsedto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class PricingRuleResponseDTO {
	
	    private Long id;

	    private String type;

	    private BigDecimal value;

	    private String condition;

	    private Integer priority;
	}


