package com.calculator.hclm.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.calculator.hclm.controller.SimpleCalculatorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.calculator.hclm.model.Calculator;
import com.calculator.hclm.repository.CalculatorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class CalculatorServiceImpl implements CalculatorService{
	
	 @Autowired
	 CalculatorRepository calculatorRepository;

	Logger logging = Logger.getLogger(CalculatorServiceImpl.class.getName());
	
	
	 public double add(int num1, int num2) {
	  double sum=0;
        try {
            sum = num1 + num2;
            Calculator calculation = calculatorRepository.save(new Calculator(num1, num2, Calculator.Operations.SUM.toString(), sum, LocalDateTime.now() ));
        } catch (Exception e) {
			logging.log(Level.SEVERE, "ADD calculation ERROR ", e.getStackTrace());
        }
        logging.log(Level.INFO, "ADD calculation result", sum);
	  return sum;
	 }

	@PutMapping("/multiply/{num1}/{num2}")
	public double multiply(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
		double result=0;
		try {
			result = num1 * num2;

			Calculator calculation = calculatorRepository.save(new Calculator(num1, num2, Calculator.Operations.MULTIPLY.toString(), result, LocalDateTime.now() ));

		} catch (Exception e) {
			logging.log(Level.SEVERE, "multiply error a"+e.getMessage());
		}
		return result;
	}

	@PutMapping("/substract/{num1}/{num2}")
	public double substract(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
		double result=0;
		try {
			result = num1 - num2;

			Calculator calculation = calculatorRepository.save(new Calculator(num1, num2, Calculator.Operations.SUBSTRACT.toString(), result, LocalDateTime.now() ));

		} catch (Exception e) {
			logging.log(Level.SEVERE, "substract error a"+e.getMessage());
		}
		return result;
	}

	@PutMapping("/divide/{num1}/{num2}")
	public double divide(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
		double result=0;
		try {
			result = (double)num1 / (double)num2;

			Calculator calculation = calculatorRepository.save(new Calculator(num1, num2, Calculator.Operations.DIVIDE.toString(), result, LocalDateTime.now() ));

		} catch (Exception e) {
			logging.log(Level.SEVERE, "divide error a"+e.getMessage());
		}
		return result;
	}

	@GetMapping("/calculations")
	public List<Calculator> getAllCalculations() {
		List<Calculator> listCalculations = new ArrayList<Calculator>();
		try {
			listCalculations = calculatorRepository.findAll();
		} catch (Exception e) {
			logging.log(Level.SEVERE, "ADD calculation ERROR ", e.getStackTrace());
		}
		logging.log(Level.INFO, "getAllCalculations.size: ", listCalculations.size());
		return listCalculations;
	}
	 
	 @Override
	public Optional<Calculator> getCalculationById(long calculationId) {
    	return calculatorRepository.findById(calculationId);
    }

}
