package com.toyota.component;

public enum WheelsRadiusType {
    RADIUS_TYPE_17(17),
    RADIUS_TYPE_16(16),
    RADIUS_TYPE_20(20);

    private final int radius;

    WheelsRadiusType(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
