package com.toyota.dealer;

import java.math.BigDecimal;

public class Customer {
    private BigDecimal money;
    private final String name;

    public Customer(String name, BigDecimal money) {
        this.name = name;
        this.money = BigDecimal.ZERO;
        this.money = this.money.add(money);
    }

    public BigDecimal getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}
