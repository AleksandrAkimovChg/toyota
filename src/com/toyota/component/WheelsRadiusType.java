package com.toyota.component;

public enum WheelsRadiusType {
    RADIUS_TYPE_17(17, "Посадочный размер 17 дюймов"),
    RADIUS_TYPE_16(16, "Посадочный размер 16 дюймов"),
    RADIUS_TYPE_20(20, "Посадочный размер 20 дюймов");

    private int radius;
    private String typeName;

    WheelsRadiusType(int radius, String radiusName) {
        this.radius = radius;
        this.typeName = radiusName;
    }

    public int getRadius() {
        return radius;
    }

    public String getTypeName() {
        return typeName;
    }
}
