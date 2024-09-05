package com.toyota.car;

public enum TransmissionType {
    AUTOMATIC("Автоматическая коробка переключения передач"),
    MANUAL("Механическая коробка переключения передач"),
    AMT("Роботизированная коробка передач");

    private final String nameType;

    TransmissionType(String nameType) {
        this.nameType = nameType;
    }

    public String getNameType() {
        return nameType;
    }
}
