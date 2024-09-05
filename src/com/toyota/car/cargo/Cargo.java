package com.toyota.car.cargo;

import com.toyota.car.Car;
import com.toyota.car.TransmissionType;
import com.toyota.component.Electrics;
import com.toyota.component.Engine;
import com.toyota.component.GasolineTank;
import com.toyota.component.Headlights;
import com.toyota.component.Wheel;
import com.toyota.component.WheelsRadiusType;

import java.math.BigDecimal;

public abstract class Cargo extends Car {
    protected final int kilogramme;

    public Cargo(String color, int maxSpeed, TransmissionType transmissionType, WheelsRadiusType wheelRadiusType,
                 Wheel[] wheels, GasolineTank gasolineTank, Engine engine, Electrics electrics, Headlights headlights,
                 BigDecimal price, int kilogramme) {
        super(color, maxSpeed, transmissionType, wheelRadiusType, wheels, gasolineTank, engine, electrics, headlights,
                price);
        this.kilogramme = kilogramme;
    }

    public int getKilogramme() {
        return kilogramme;
    }
}
