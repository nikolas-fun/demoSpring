package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	private int number1;
    private int number2;
    private String operation;
    private int result;

    /*// Addition
    int sum = number1 + number2;

    // Subtraction
    int diff = number1 - number2;

    // Multiplication
    int mul = number1 * number2;

    // Division
    int div = number1 / number2;*/

}
