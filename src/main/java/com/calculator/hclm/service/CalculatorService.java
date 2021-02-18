package com.calculator.hclm.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.calculator.hclm.model.Calculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public interface CalculatorService {

	double add(int num1, int num2);
	double multiply(int num1, int num2);
	double divide(int num1, int num2);
	double substract(int num1, int num2);

	Optional<Calculator> getCalculationById(long calculationId);
	List<Calculator> getAllCalculations();



}
