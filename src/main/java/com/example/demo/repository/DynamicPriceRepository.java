package com.example.demo.repository;

import com.example.demo.entity.DynamicPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicPriceRepository extends JpaRepository<DynamicPrice, Long> {

}