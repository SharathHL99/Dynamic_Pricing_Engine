package com.example.demo.requestdto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DynamicPricingRequestDTO {


	    @NotNull(message = "Product Id is required")
	    private Long productId;

	    @Min(value = 0, message = "Demand cannot be negative")
	    private Integer demand;

	    @Min(value = 0, message = "Inventory cannot be negative")
	    private Integer inventory;

	    @Min(0)
	    private Integer hour;
	}

