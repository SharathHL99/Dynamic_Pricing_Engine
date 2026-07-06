package com.example.demo.requestdto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter

public class PricingRuleRequestDTO {

	    @NotBlank(message = "Rule type is required")
	    private String type;

	    @NotNull(message = "Rule value is required")
	    @DecimalMin(value = "0.0", inclusive = false)
	    private BigDecimal value;

	    @NotBlank(message = "Condition is required")
	    private String condition;

	    private Integer priority;
	    
	}


