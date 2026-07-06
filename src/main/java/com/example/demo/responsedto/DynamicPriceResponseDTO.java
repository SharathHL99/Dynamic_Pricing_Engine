package com.example.demo.responsedto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter

public class DynamicPriceResponseDTO {
	
	
	    private Long id;

	    private Long productId;

	    private String productName;

	    private BigDecimal basePrice;

	    private BigDecimal finalPrice;

	    private LocalDateTime timestamp;
	}


