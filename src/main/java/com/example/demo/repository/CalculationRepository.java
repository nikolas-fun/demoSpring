package com.example.demo.repository;

import com.example.demo.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CalculationRepository extends JpaRepository<Calculation, Integer> {
}