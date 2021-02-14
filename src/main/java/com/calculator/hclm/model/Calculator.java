package com.calculator.hclm.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "calculations")
public class Calculator {

    public enum Operations {
        SUM("sum"), SUBSTRACT("SUBSTRACT"),  MULTIPLY("MULTIPLY"), DIVIDE("DIVIDE");
        private final String stringValue;
        Operations(final String s) { stringValue = s; }
        public String toString() { return stringValue; }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "operandA")
    private int operandA;

    @Column(name = "operandB")
    private int operandB;

    @Column(name = "operation")
    private String operation;

    @Column(name = "result")
    private double result;

    @Column(name= "date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime localDateTime;

    public Calculator(){

    }

    public Calculator(int operandA, int operandB, String operation, double result, LocalDateTime localDateTime) {
        this.operandA = operandA;
        this.operandB = operandB;
        this.operation = operation;
        this.result = result;
        this.localDateTime = localDateTime;
    }


    public long getId() {
        return id;
    }
/*
    public void setId(long id) {
        this.id = id;
    }
*/
    public int getOperandA() {
        return operandA;
    }

    public void setOperandA(int operandA) {
        this.operandA = operandA;
    }

    public int getOperandB() {
        return operandB;
    }

    public void setOperandB(int operandB) {
        this.operandB = operandB;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
