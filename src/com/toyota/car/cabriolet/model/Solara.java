package com.toyota.car.cabriolet.model;

import com.toyota.car.TransmissionType;
import com.toyota.car.cabriolet.Cabriolet;
import com.toyota.component.Electrics;
import com.toyota.component.Engine;
import com.toyota.component.GasolineTank;
import com.toyota.component.Headlights;
import com.toyota.component.Wheel;
import com.toyota.component.WheelsRadiusType;
import com.toyota.component.MiniFridge;

import java.math.BigDecimal;

public class Solara extends Cabriolet {
    private MiniFridge miniFridge;

    public Solara(String color, int maxSpeed, TransmissionType transmissionType, WheelsRadiusType wheelRadiusType,
                  Wheel[] wheels, GasolineTank gasolineTank, Engine engine, Electrics electrics, Headlights headlights,
                  MiniFridge miniFridge, BigDecimal price) {
        super(color, maxSpeed, transmissionType, wheelRadiusType, wheels, gasolineTank, engine, electrics, headlights,
                price);
        this.miniFridge = miniFridge;
    }


    public Solara(String color, int maxSpeed, TransmissionType transmissionType, WheelsRadiusType wheelRadiusType, Wheel[] wheels, GasolineTank gasolineTank, Engine engine, Electrics electrics, Headlights headlights, BigDecimal price, MiniFridge miniFridge) {
        super(color, maxSpeed, transmissionType, wheelRadiusType, wheels, gasolineTank, engine, electrics, headlights, price);

    }

    public boolean isMiniFridgeOn() {
        return miniFridge.isMiniFridgeOn();
    }

    public void fridgeDrinkOn() {
        if (!miniFridge.isMiniFridgeOn()) {
            this.miniFridge.setMiniFridgeOn(true);
            System.out.println("Охлаждается напиток");
        }
    }

    public void fridgeDrinkOff() {
        if (miniFridge.isMiniFridgeOn()) {
            this.miniFridge.setMiniFridgeOn(false);
            System.out.println("Холодильник не drl.xty");
        }
    }
}
