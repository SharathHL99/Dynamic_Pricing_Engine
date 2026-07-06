package com.example.demo.controller;

import com.example.demo.requestdto.ProductRequestDTO;
import com.example.demo.responsedto.ProductResponseDTO;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO requestDTO) {

        log.info("Received request to create product: {}", requestDTO);

        ProductResponseDTO response = productService.createProduct(requestDTO);

        log.info("Product created successfully with ID: {}", response.getId());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {

        log.info("Received request to fetch product with ID: {}", id);

        ProductResponseDTO response = productService.getProductById(id);

        log.info("Successfully fetched product with ID: {}", id);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {

        log.info("Received request to fetch all products");

        List<ProductResponseDTO> products = productService.getAllProducts();

        log.info("Successfully fetched {} products", products.size());

        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO requestDTO) {

        log.info("Received request to update product with ID: {}", id);

        ProductResponseDTO response = productService.updateProduct(id, requestDTO);

        log.info("Product updated successfully with ID: {}", id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {

        log.info("Received request to delete product with ID: {}", id);

        productService.deleteProduct(id);

        log.info("Product deleted successfully with ID: {}", id);

        return ResponseEntity.ok("Product deleted successfully.");
    }
}
