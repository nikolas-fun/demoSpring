package com.example.demo.service;

import com.example.demo.model.Calculation;
import com.example.demo.repository.CalculationRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    public CalculationRepository calculationRepository;

    public CalculatorService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public int sum(Calculation calculation) {
        int result = 0;

        switch (calculation.getOperation()) {
            case "+":
                result = calculation.getNumber1() + calculation.getNumber2();
                break;
            case "-":
                result = calculation.getNumber1() - calculation.getNumber2();
                break;
            case "*":
                result = calculation.getNumber1() * calculation.getNumber2();
                break;
            case "/":
                if (calculation.getNumber2() == 0) {
                    throw new RuntimeException("На ноль делить нельзя");

                }
                result = calculation.getNumber1() / calculation.getNumber2();
                break;
            default:
                throw new RuntimeException("Неизвестная операция");

        }
        calculation.setResult(result);
        calculationRepository.save(calculation);
        return result ;
    }


    public List<Calculation> getAll(){
        return calculationRepository.findAll();
    }
}
