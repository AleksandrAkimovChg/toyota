package com.toyota.dealer;

import com.toyota.car.Car;

import java.math.BigDecimal;

public class Cashier {
    private static BigDecimal income = BigDecimal.ZERO;

    public static void order(Car car) {
        if (car != null) {
            income = income.add(car.getPrice());
            System.out.println("С покупочкой " + car);
        }
    }

    public static void printIncome() {
        System.out.println(income);
    }
}
