package com.calculator.hclm.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.calculator.hclm.model.Calculator;
import com.calculator.hclm.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*",allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class SimpleCalculatorController {

    @Autowired
    CalculatorService calculatorService;

    Logger logging = Logger.getLogger(SimpleCalculatorController.class.getName());

    @PutMapping("/add/{num1}/{num2}")
    public double add(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
        System.out.println("ADD");
        double sum=0;
        try {
            sum = num1 + num2;
            sum = calculatorService.add(num1, num2);

        } catch (Exception e) {
            logging.log(Level.SEVERE, "ADD error a"+e.getMessage());

        }
        return sum;
    }

    @GetMapping("/calculationid/{calculationid}")
    public Optional<Calculator> getCalculationById(@PathVariable("calculationid") long calculationId) {
        return calculatorService.getCalculationById(calculationId);
    }



    @GetMapping("/calculations")
    public ResponseEntity<List<Calculator>> getAllCalculations() {
        try {
            List<Calculator> calculations = calculatorService.getAllCalculations();

            if (calculations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(calculations, HttpStatus.OK);
        } catch (Exception e) {
            logging.log(Level.SEVERE, "listCalculations error a"+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/multiply/{num1}/{num2}")
    public double multiply(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
        double result=0;
        try {

            result = calculatorService.multiply(num1, num2);

        } catch (Exception e) {
            logging.log(Level.SEVERE, "multiply error a"+e.getMessage());
        }
        return result;
    }

    @PutMapping("/divide/{num1}/{num2}")
    public double divide(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
        double result=0;
        try {
            result = calculatorService.divide(num1, num2);
        } catch (Exception e) {
            logging.log(Level.SEVERE, "divide error a"+e.getMessage());
        }
        return result;
    }

    @PutMapping("/substract/{num1}/{num2}")
    public double substract(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {
        double result=0;
        try {

            result = calculatorService.substract(num1, num2);

        } catch (Exception e) {
            logging.log(Level.SEVERE, "multiply error a"+e.getMessage());
        }
    return result;
    }

}
