package com.toyota.component;

public class Wheel {
    private boolean isFlat;
    private final WheelsRadiusType whellRadiusType;

    public Wheel(WheelsRadiusType whellRadiusType) {
        this.whellRadiusType = whellRadiusType;
    }

    public boolean isFlat() {
        return isFlat;
    }

    public void setFlat(boolean bool) {
        isFlat = true;
    }

    public WheelsRadiusType getWheelRadiusType() {
        return whellRadiusType;
    }
}
