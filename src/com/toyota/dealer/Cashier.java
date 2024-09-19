package com.toyota.dealer;

import com.toyota.car.Car;

import java.math.BigDecimal;

public class Cashier {
    private static BigDecimal income;

    public Cashier() {
        income = BigDecimal.ZERO;
    }

    public void order(Car car) {
        income = income.add(car.getPrice());
    }
}
