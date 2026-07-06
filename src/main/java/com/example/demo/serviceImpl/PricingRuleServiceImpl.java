package com.example.demo.serviceImpl;

import com.example.demo.requestdto.PricingRuleRequestDTO;
import com.example.demo.responsedto.PricingRuleResponseDTO;
import com.example.demo.entity.PricingRule;
import com.example.demo.enums.PricingRuleType;
import com.example.demo.repository.PricingRuleRepository;
import com.example.demo.service.PricingRuleService;
	import jakarta.transaction.Transactional;
	import lombok.RequiredArgsConstructor;
	import org.springframework.stereotype.Service;

	import java.util.ArrayList;
	import java.util.List;

	@Service
	@RequiredArgsConstructor
	@Transactional
	public class PricingRuleServiceImpl implements PricingRuleService {

	    private final PricingRuleRepository pricingRuleRepository;

	    @Override
	    public PricingRuleResponseDTO createRule(PricingRuleRequestDTO requestDTO) {

	        PricingRule pricingRule = new PricingRule();

	        pricingRule.setType(PricingRuleType.valueOf(requestDTO.getType().toUpperCase()));
	        pricingRule.setValue(requestDTO.getValue());
	        pricingRule.setCondition(requestDTO.getCondition());
	        pricingRule.setPriority(requestDTO.getPriority());

	        PricingRule savedRule = pricingRuleRepository.save(pricingRule);

	        return mapToResponse(savedRule);
	    }

	    @Override
	    public PricingRuleResponseDTO getRuleById(Long id) {

	        PricingRule pricingRule = pricingRuleRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException("Pricing Rule not found with id : " + id));

	        return mapToResponse(pricingRule);
	    }

	    @Override
	    public List<PricingRuleResponseDTO> getAllRules() {

	        List<PricingRule> pricingRules = pricingRuleRepository.findAll();

	        List<PricingRuleResponseDTO> responseList = new ArrayList<>();

	        for (PricingRule pricingRule : pricingRules) {
	            responseList.add(mapToResponse(pricingRule));
	        }

	        return responseList;
	    }

	    @Override
	    public PricingRuleResponseDTO updateRule(Long id, PricingRuleRequestDTO requestDTO) {

	        PricingRule pricingRule = pricingRuleRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException("Pricing Rule not found with id : " + id));

	        pricingRule.setType(PricingRuleType.valueOf(requestDTO.getType().toUpperCase()));
	        pricingRule.setValue(requestDTO.getValue());
	        pricingRule.setCondition(requestDTO.getCondition());
	        pricingRule.setPriority(requestDTO.getPriority());

	        PricingRule updatedRule = pricingRuleRepository.save(pricingRule);

	        return mapToResponse(updatedRule);
	    }

	    @Override
	    public void deleteRule(Long id) {

	        PricingRule pricingRule = pricingRuleRepository.findById(id).orElseThrow(() ->
	                        new RuntimeException("Pricing Rule not found with id : " + id));

	        pricingRuleRepository.delete(pricingRule);
	    }

	   
	    private PricingRuleResponseDTO mapToResponse(PricingRule pricingRule) {

	        PricingRuleResponseDTO dto = new PricingRuleResponseDTO();

	        dto.setId(pricingRule.getId());
	        dto.setType(pricingRule.getType().name());
	        dto.setValue(pricingRule.getValue());
	        dto.setCondition(pricingRule.getCondition());
	        dto.setPriority(pricingRule.getPriority());

	        return dto;
	    }
	}


