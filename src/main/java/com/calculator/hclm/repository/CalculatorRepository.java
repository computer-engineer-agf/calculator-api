package com.calculator.hclm.repository;

import com.calculator.hclm.model.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepository extends JpaRepository<Calculator, Long> {
}
