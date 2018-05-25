package com.example.demo.examples;

import lombok.Data;

@Data
public class SimpleInterestCalculator {

    private double rate;

    public double calculate(double amount, double year) {
        if (amount < 0 || year < 0) {
            throw new IllegalArgumentException("Amount or year must be positive");
        }
        return amount * year * rate;
    }

}
