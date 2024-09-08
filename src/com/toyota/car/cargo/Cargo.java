package com.toyota.car.cargo;

import com.toyota.car.Car;
import com.toyota.car.TransmissionType;
import com.toyota.component.*;

import java.math.BigDecimal;

public abstract class Cargo extends Car {
    protected final int maxCapacity;

    public Cargo(String color, int maxSpeed, TransmissionType transmissionType, Transmission transmission, WheelsRadiusType wheelRadiusType,
                 Wheel[] wheels, GasolineTank gasolineTank, Engine engine, Electrics electrics, Headlights headlights,
                 BigDecimal price, int maxCapacity) {
        super(color, maxSpeed, transmissionType, transmission, wheelRadiusType, wheels, gasolineTank, engine, electrics, headlights,
                price);
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
