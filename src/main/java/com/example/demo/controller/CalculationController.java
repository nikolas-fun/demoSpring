package com.example.demo.controller;

import com.example.demo.model.Calculation;
import com.example.demo.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculationController {

    private CalculatorService calculatorService;

    public CalculationController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public String showCalculatorPage(Model model) {
        model.addAttribute("calculation", new Calculation());
        return "calculation/calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute Calculation calculation,  Model model){
        try{
            int result = calculatorService.sum(calculation);
            model.addAttribute("result", result);
        }
        catch (RuntimeException runtimeException){
            model.addAttribute("error", runtimeException.getMessage());
        }

        return "calculation/calculator";
    }

    @GetMapping("/history")
    public String showHistory(Model model) {

        model.addAttribute("calculations", calculatorService.getAll());// select * from calculator

        return "calculation/history";
    }
}