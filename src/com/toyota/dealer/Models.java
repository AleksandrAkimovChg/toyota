package com.toyota.dealer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Models {
    CAMRY("Camry", new BigDecimal(10_000), new BigDecimal(5_000)),
    SOLARA("Solara", new BigDecimal(12_000), new BigDecimal(8_000)),
    HIANCE("Hiance", new BigDecimal(15_000), new BigDecimal(10_000)),
    DYNA("Dyna", new BigDecimal(22_000), new BigDecimal(12_000));

    private String name;
    private BigDecimal dealerPrice;
    private BigDecimal coast;

    Models(String name, BigDecimal dealerPrice, BigDecimal coast) {
        this.name = name;
        this.dealerPrice = dealerPrice;
        this.dealerPrice.setScale(2, RoundingMode.HALF_UP);;
        this.coast = coast;
        this.coast.setScale(2, RoundingMode.HALF_UP);
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
