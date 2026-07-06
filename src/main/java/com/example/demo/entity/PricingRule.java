package com.example.demo.entity;

import com.example.demo.enums.PricingRuleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "pricing_rules")
@Getter
@Setter
public class PricingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PricingRuleType type;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(name = "rule_condition", nullable = false)
    private String condition;

    @Column(nullable = false)
    private Integer priority;

    @Version
    private Long version;
}