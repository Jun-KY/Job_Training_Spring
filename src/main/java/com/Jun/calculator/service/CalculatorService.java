package com.Jun.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(double num1, double num2, String operation) {
        switch (operation){
            case "add" :
                return num1 + num2;
            case "subtract" :
                return  num1 - num2;
            case "multiply" :
                return  num1 * num2;
            case "divide" :
                if (num2 == 0) throw new IllegalArgumentException("Cannot divide by 0");
                return num1 / num2;

            default:
                throw new IllegalArgumentException("Unspecified operator ");

        }
    }
}
