package com.example.demo.serviceImpl;



import com.example.demo.requestdto.DynamicPricingRequestDTO;
import com.example.demo.responsedto.DynamicPriceResponseDTO;
import com.example.demo.entity.DynamicPrice;
import com.example.demo.entity.PricingRule;
import com.example.demo.entity.Product;
import com.example.demo.factory.PricingStrategyFactory;
import com.example.demo.repository.DynamicPriceRepository;
import com.example.demo.repository.PricingRuleRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.PricingService;
import com.example.demo.strategy.PricingStrategy;
	import jakarta.transaction.Transactional;
	import lombok.RequiredArgsConstructor;
	import org.springframework.stereotype.Service;

	import java.math.BigDecimal;
	import java.time.LocalDateTime;
	import java.util.List;

	@Service
	@RequiredArgsConstructor
	@Transactional
	public class PricingServiceImpl implements PricingService {

	    private final ProductRepository productRepository;
	    private final PricingRuleRepository pricingRuleRepository;
	    private final DynamicPriceRepository dynamicPriceRepository;
	    private final PricingStrategyFactory pricingStrategyFactory;

	    @Override
	    public DynamicPriceResponseDTO calculatePrice(DynamicPricingRequestDTO requestDTO) {

	        Product product = productRepository.findById(requestDTO.getProductId())
	                .orElseThrow(() ->
	                        new RuntimeException("Product not found with id : "
	                                + requestDTO.getProductId()));

	        BigDecimal finalPrice = product.getBasePrice();

	        List<PricingRule> pricingRules =pricingRuleRepository.findAllByOrderByPriorityAsc();

	        for (PricingRule pricingRule : pricingRules) {

	            PricingStrategy strategy =pricingStrategyFactory.getStrategy(pricingRule.getType());

	            finalPrice = strategy.applyPrice(finalPrice,pricingRule, requestDTO.getDemand(),requestDTO.getInventory(),requestDTO.getHour()
	            );
	        }

	        DynamicPrice dynamicPrice = new DynamicPrice();
	        dynamicPrice.setProduct(product);
	        dynamicPrice.setFinalPrice(finalPrice);
	        dynamicPrice.setTimestamp(LocalDateTime.now());

	        DynamicPrice savedPrice = dynamicPriceRepository.save(dynamicPrice);

	        return mapToResponse(savedPrice);
	    }

	    private DynamicPriceResponseDTO mapToResponse(DynamicPrice dynamicPrice) {

	        DynamicPriceResponseDTO dto = new DynamicPriceResponseDTO();

	        dto.setId(dynamicPrice.getId());
	        dto.setProductId(dynamicPrice.getProduct().getId());
	        dto.setProductName(dynamicPrice.getProduct().getName());
	        dto.setBasePrice(dynamicPrice.getProduct().getBasePrice());
	        dto.setFinalPrice(dynamicPrice.getFinalPrice());
	        dto.setTimestamp(dynamicPrice.getTimestamp());

	        return dto;
	    }
	}


