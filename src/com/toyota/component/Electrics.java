package com.toyota.component;

public class Electrics {
    private boolean isElectricsGood;

    public Electrics(boolean isElectricsGood) {
        this.isElectricsGood = isElectricsGood;
    }

    public boolean isElectricsGood() {
        return isElectricsGood;
    }

    public void setElectricsGood(boolean bool) {
        this.isElectricsGood = bool;
    }
}
