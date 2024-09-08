package com.toyota.car.cargo.model;

import com.toyota.car.TransmissionType;
import com.toyota.car.cargo.Cargo;
import com.toyota.component.*;

import java.math.BigDecimal;

public class Hiance extends Cargo {
    private Wheel spareWheel;

    public Hiance(String color, int maxSpeed, TransmissionType transmissionType, Transmission transmission,
                  WheelsRadiusType wheelRadiusType, Wheel[] wheels, GasolineTank gasolineTank, Engine engine,
                  Electrics electrics, Headlights headlights, BigDecimal price, int maxCapacity, Wheel spareWheel) {
        super(color, maxSpeed, transmissionType, transmission, wheelRadiusType, wheels, gasolineTank, engine, electrics,
                headlights, price, maxCapacity);
        this.spareWheel = spareWheel;
    }

    public Wheel getSpareWheel() {
        return spareWheel;
    }
}
