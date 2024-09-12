package com.toyota.component;

public class Wheel {
    private boolean isFlat;
    private final WheelsRadiusType wheelRadiusType;

    public Wheel(WheelsRadiusType wheelRadiusType) {
        this.wheelRadiusType = wheelRadiusType;
    }

    public boolean isFlat() {
        return isFlat;
    }

    public void setFlat(boolean bool) {
        isFlat = true;
    }

    public WheelsRadiusType getWheelRadiusType() {
        return wheelRadiusType;
    }
}
