package com.toyota.dealer;

import java.math.BigDecimal;

public enum Models {
    CAMRY("Camry", new BigDecimal(10_000), new BigDecimal(5_000)),
    SOLARA("Solara", new BigDecimal(12_000), new BigDecimal(8_000)),
    HIANCE("Hiance", new BigDecimal(15_000), new BigDecimal(10_000)),
    DYNA("Dyna", new BigDecimal(22_000), new BigDecimal(12_000));

    private final String name;
    private final BigDecimal dealerPrice;
    private final BigDecimal coast;

    Models(String name, BigDecimal dealerPrice, BigDecimal coast) {
        this.name = name;
        this.dealerPrice = dealerPrice;
        this.coast = coast;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getDealerPrice() {
        return dealerPrice;
    }

    public BigDecimal getCoast() {
        return coast;
    }
}
