package com.toyota.dealer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Models {
    CAMRY("Camry",
            new BigDecimal(10_000).setScale(2, RoundingMode.HALF_UP),
            new BigDecimal(5_000).setScale(2, RoundingMode.HALF_UP)),
    SOLARA("Solara",
            new BigDecimal(12_000).setScale(2, RoundingMode.HALF_UP),
            new BigDecimal(8_000).setScale(2, RoundingMode.HALF_UP)),
    HIANCE("Hiance",
            new BigDecimal(15_000).setScale(2, RoundingMode.HALF_UP),
            new BigDecimal(10_000).setScale(2, RoundingMode.HALF_UP)),
    DYNA("Dyna",
            new BigDecimal(22_000).setScale(2, RoundingMode.HALF_UP),
            new BigDecimal(12_000).setScale(2, RoundingMode.HALF_UP));

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
