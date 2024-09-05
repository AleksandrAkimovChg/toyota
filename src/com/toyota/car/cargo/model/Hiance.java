package com.toyota.car.cargo.model;

import com.toyota.car.TransmissionType;
import com.toyota.car.cargo.Cargo;
import com.toyota.component.Electrics;
import com.toyota.component.Engine;
import com.toyota.component.GasolineTank;
import com.toyota.component.Headlights;
import com.toyota.component.Wheel;
import com.toyota.component.WheelsRadiusType;

import java.math.BigDecimal;

public class Hiance extends Cargo {
    private Wheel spareWheel;

    public Hiance(String color, int maxSpeed, TransmissionType transmissionType, WheelsRadiusType wheelRadiusType,
                  Wheel[] wheels, GasolineTank gasolineTank, Engine engine, Electrics electrics, Headlights headlights,
                  BigDecimal price, int kilogramme, Wheel spareWheel) {
        super(color, maxSpeed, transmissionType, wheelRadiusType, wheels, gasolineTank, engine, electrics, headlights,
                price, kilogramme);
        this.spareWheel = spareWheel;
    }

    public Wheel getSpareWheel() {
        return spareWheel;
    }
}
