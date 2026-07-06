package com.example.demo.requestdto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter

public class ProductRequestDTO {

	    @NotBlank(message = "Mention the product name")
	    private String name;

	    @NotNull(message = "Mention the base price")
	    @DecimalMin(value = "0.0", inclusive = false, message = "Base price must be greater than zero")
	    private BigDecimal basePrice;
	    
	}


