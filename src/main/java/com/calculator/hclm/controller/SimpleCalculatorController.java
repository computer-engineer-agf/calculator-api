package com.calculator.hclm.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.calculator.hclm.model.Calculator;
import com.calculator.hclm.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*",allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class SimpleCalculatorController {

    @Autowired
    CalculatorRepository calculatorRepository;

    @GetMapping("/calculations")
    public ResponseEntity<List<Calculator>> getAllCalculations() {
        try {
            List<Calculator> calculations = new ArrayList<Calculator>();

            calculations = calculatorRepository.findAll();

            if (calculations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(calculations, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("error: "+e.getStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/createcalculation")
    public ResponseEntity<Calculator> createCalculation(@RequestBody Calculator calculator) {
        try {

           Calculator calculation = calculatorRepository.save(new Calculator(calculator.getOperandA(), calculator.getOperandB(), calculator.getOperation(), calculator.getResult(), LocalDateTime.now() ));

           return new ResponseEntity<>(calculation, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("error: "+e.getStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/add/{num1}/{num2}")
    public double add(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
        double sum=0;
        try {
            sum = num1 + num2;

            Calculator calculation = calculatorRepository.save(new Calculator(num1, num2, Calculator.Operations.SUM.toString(), sum, LocalDateTime.now() ));

        } catch (Exception e) {
            System.out.println("ADD error a"+e.getStackTrace());
        }
        return sum;
    }

    @PutMapping("/substract/{num1}/{num2}")
    public double substract(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
        double result=0;
        try {
            result = num1 - num2;

            Calculator calculation = calculatorRepository.save(new Calculator(num1, num2, Calculator.Operations.SUM.toString(), result, LocalDateTime.now() ));

        } catch (Exception e) {
            System.out.println(Calculator.Operations.SUBSTRACT.toString()+" error "+e.getStackTrace());
        }
        return result;
    }

    @PutMapping("/multiply/{num1}/{num2}")
    public double multiply(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
        double result=0;
        try {
            result = num1 * num2;

            Calculator calculation = calculatorRepository.save(new Calculator(num1, num2, Calculator.Operations.MULTIPLY.toString(), result, LocalDateTime.now() ));

        } catch (Exception e) {
            System.out.println(Calculator.Operations.SUBSTRACT.toString()+" error "+e.getStackTrace());
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
            System.out.println(Calculator.Operations.DIVIDE.toString()+" error "+e.getStackTrace());
        }
        return result;
    }




}
