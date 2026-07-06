package com.example.demo.controller;


import com.example.demo.requestdto.ProductRequestDTO;
import com.example.demo.responsedto.ProductResponseDTO;
import com.example.demo.service.ProductService;
	import jakarta.validation.Valid;
	import lombok.RequiredArgsConstructor;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/api/products")
	@RequiredArgsConstructor
	public class ProductController {

	    private final ProductService productService;

	    @PostMapping
	    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO requestDTO) {

	        return new ResponseEntity<>(productService.createProduct(requestDTO),
	                HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {

	        return ResponseEntity.ok(productService.getProductById(id));
	    }

	    @GetMapping
	    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {

	        return ResponseEntity.ok(productService.getAllProducts());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO requestDTO) {

	        return ResponseEntity.ok(productService.updateProduct(id, requestDTO));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {

	        productService.deleteProduct(id);
	        return ResponseEntity.ok("Product deleted successfully.");
	    }
	}


