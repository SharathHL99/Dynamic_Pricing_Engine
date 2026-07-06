package com.example.demo.serviceImpl;



import com.example.demo.requestdto.ProductRequestDTO;
import com.example.demo.responsedto.ProductResponseDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
	import jakarta.transaction.Transactional;
	import lombok.RequiredArgsConstructor;
	import org.springframework.stereotype.Service;

	import java.util.ArrayList;
	import java.util.List;

	@Service
	@RequiredArgsConstructor
	@Transactional
	public class ProductServiceImpl implements ProductService {

	    private final ProductRepository productRepository;

	    @Override
	    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {

	        Product product = new Product();

	        product.setName(requestDTO.getName());
	        product.setBasePrice(requestDTO.getBasePrice());

	        Product savedProduct = productRepository.save(product);

	        return mapToResponse(savedProduct);
	    }

	    @Override
	    public ProductResponseDTO getProductById(Long id) {

	        Product product = productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found with id : " + id));

	        return mapToResponse(product);
	    }

	    @Override
	    public List<ProductResponseDTO> getAllProducts() {

	        List<Product> products = productRepository.findAll();

	        List<ProductResponseDTO> responseList = new ArrayList<>();

	        for (Product product : products) {
	            responseList.add(mapToResponse(product));
	        }

	        return responseList;
	    }

	    @Override
	    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO) {

	        Product product = productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found with id : " + id));

	        product.setName(requestDTO.getName());
	        product.setBasePrice(requestDTO.getBasePrice());

	        Product updatedProduct = productRepository.save(product);

	        return mapToResponse(updatedProduct);
	    }

	    @Override
	    public void deleteProduct(Long id) {

	        Product product = productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found with id : " + id));

	        productRepository.delete(product);
	    }

	   
	    private ProductResponseDTO mapToResponse(Product product) {

	        ProductResponseDTO dto = new ProductResponseDTO();

	        dto.setId(product.getId());
	        dto.setName(product.getName());
	        dto.setBasePrice(product.getBasePrice());

	        return dto;
	    }
	}


