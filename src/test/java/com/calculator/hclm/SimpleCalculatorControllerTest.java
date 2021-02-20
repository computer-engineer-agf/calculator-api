package com.calculator.hclm;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.calculator.hclm.controller.SimpleCalculatorController;
import com.calculator.hclm.model.Calculator;
import com.calculator.hclm.service.CalculatorService;

import org.junit.Assert;

@WebMvcTest(SimpleCalculatorController.class)
public class SimpleCalculatorControllerTest {
    
    @MockBean
    private CalculatorService calculatorService;

    Logger logging = Logger.getLogger(SimpleCalculatorControllerTest.class.getName());

    @Test
    void addCalculationTest() throws Exception {
        //Stubbing
        Mockito.when(calculatorService.add(1, 1)).thenReturn(2.0);
        //Validate
        Assertions.assertEquals(2.0,calculatorService.add(1, 1));
    }

    @Test
    void multiplyCalculationTest() throws Exception {
        //Stubbing
        Mockito.when(calculatorService.multiply(3, 1)).thenReturn(3.0);
        //Validate
        Assertions.assertEquals(3.0,calculatorService.multiply(3, 1));
    }

    @Test
    void divideCalculationTest() throws Exception {
        //Stubbing
        Mockito.when(calculatorService.divide(55, 4)).thenReturn(13.75);
        //Validate
        Assert.assertEquals(13.75,calculatorService.divide(55, 4),0);
    }

    @Test
    void divideCalculationTestByZero() throws Exception {
        //Stubbing
        Mockito.when(calculatorService.divide(55, 0)).thenReturn(Double.POSITIVE_INFINITY);
        //Validate
        Assert.assertEquals(Double.POSITIVE_INFINITY,calculatorService.divide(55, 0),0);
    }

    @Test
    void substractCalculationTest() throws Exception {
        //Stubbing
        Mockito.when(calculatorService.substract(23, 2)).thenReturn(21.0);
        //Validate
        Assert.assertEquals(21.0,calculatorService.substract(23, 2),0);
    }

    @Test
    void getCalculations() throws Exception {
        Calculator mockCalc1 = new Calculator(1, 2, Calculator.Operations.MULTIPLY.toString(), 1, LocalDateTime.now());
        Calculator mockCalc2 = new Calculator(16, 4, Calculator.Operations.DIVIDE.toString(), 4, LocalDateTime.now());
        List<Calculator> listCalculations = calculatorService.getAllCalculations();
        //Stubbing
        Mockito.when(listCalculations).thenReturn(Arrays.asList(mockCalc1, mockCalc2));

        Assert.assertNotNull(calculatorService.getAllCalculations());
        Assert.assertEquals(2,calculatorService.getAllCalculations().size(),0);
    }
}
