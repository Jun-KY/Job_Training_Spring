package com.Jun.calculator.controller;

import com.Jun.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping ("/cal")
    public String showCalculator(){
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculate(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("operation") String operation,
            Model model
    ) {
        try {
            double result = calculatorService.calculate(num1, num2, operation);
            model.addAttribute("result", result);
        } catch(IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "calculator";
    }
}
