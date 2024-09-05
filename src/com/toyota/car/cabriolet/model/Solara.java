package com.toyota.car.cabriolet.model;

import com.toyota.car.TransmissionType;
import com.toyota.car.cabriolet.Cabriolet;
import com.toyota.component.Electrics;
import com.toyota.component.Engine;
import com.toyota.component.GasolineTank;
import com.toyota.component.Headlights;
import com.toyota.component.Wheel;
import com.toyota.component.WheelsRadiusType;

import java.math.BigDecimal;

public class Solara extends Cabriolet {
    private boolean miniFridgeOn = false;

    public Solara(String color, int maxSpeed, TransmissionType transmissionType, WheelsRadiusType wheelRadiusType,
                  Wheel[] wheels, GasolineTank gasolineTank, Engine engine, Electrics electrics, Headlights headlights,
                  BigDecimal price) {
        super(color, maxSpeed, transmissionType, wheelRadiusType, wheels, gasolineTank, engine, electrics, headlights,
                price);
    }

    public boolean isMiniFridgeOn() {
        return miniFridgeOn;
    }

    public void fridgeDrinkOn() {
        if (!miniFridgeOn) {
            this.miniFridgeOn = true;
            System.out.println("Охлаждается напиток");
        }
    }

    public void fridgeDrinkOff() {
        if (miniFridgeOn) {
            this.miniFridgeOn = true;
            System.out.println("Напиток не охлаждается");
        }
    }
}
