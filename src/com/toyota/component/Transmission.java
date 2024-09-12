package com.toyota.component;

import com.toyota.car.TransmissionType;

public class Transmission {
    private final TransmissionType transmissionType;
    private boolean isTransmissionGood;

    public Transmission(TransmissionType transmissionType, boolean isTransmissionGood) {
        this.transmissionType = transmissionType;
        this.isTransmissionGood = isTransmissionGood;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public boolean isTransmissionGood() {
        return isTransmissionGood;
    }

    public void setTransmissionGood(boolean bool) {
        isTransmissionGood = bool;
    }
}
