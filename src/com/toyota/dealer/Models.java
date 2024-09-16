package com.toyota.dealer;

import java.math.BigDecimal;

public enum Models {
    CAMRY("Camry", new BigDecimal(10_000)),
    SOLARA("Solara", new BigDecimal(12_000)),
    HIANCE("Hiance", new BigDecimal(15_000)),
    DYNA("Dyna", new BigDecimal(22_000));

    private String name;
    private BigDecimal dealerPrice;

    Models(String name, BigDecimal dealerPrice) {
        this.name = name;
        this.dealerPrice = dealerPrice;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getDealerPrice() {
        return dealerPrice;
    }
}
