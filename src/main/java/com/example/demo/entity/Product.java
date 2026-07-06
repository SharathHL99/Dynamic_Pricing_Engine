package com.example.demo.entity;


	import jakarta.persistence.*;
	import lombok.Getter;
	import lombok.Setter;

	import java.math.BigDecimal;

	@Entity
	@Table(name = "products")
	@Getter
	@Setter
	public class Product {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Column(name = "base_price", nullable = false)
	    private BigDecimal basePrice;

	    @Version
	    private Long version;
	}


