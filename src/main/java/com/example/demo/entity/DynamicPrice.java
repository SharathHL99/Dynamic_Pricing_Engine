package com.example.demo.entity;


	import jakarta.persistence.*;
	import lombok.Getter;
	import lombok.Setter;

	import java.math.BigDecimal;
	import java.time.LocalDateTime;

	@Entity
	@Table(name = "dynamic_prices")
	@Getter
	@Setter
	public class DynamicPrice {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "product_id", nullable = false)
	    private Product product;

	    @Column(name = "final_price", nullable = false)
	    private BigDecimal finalPrice;

	    @Column(nullable = false)
	    private LocalDateTime timestamp;
	}


