package com.toyota.car.cabriolet;

import com.toyota.car.Car;
import com.toyota.car.TransmissionType;
import com.toyota.component.Electrics;
import com.toyota.component.Engine;
import com.toyota.component.GasolineTank;
import com.toyota.component.Headlights;
import com.toyota.component.Wheel;
import com.toyota.component.WheelsRadiusType;

import java.math.BigDecimal;

public abstract class Cabriolet extends Car {
    protected boolean isCabrioletTopDown;

    public Cabriolet(String color, int maxSpeed, TransmissionType transmissionType, WheelsRadiusType wheelRadiusType,
                     Wheel[] wheels, GasolineTank gasolineTank, Engine engine, Electrics electrics,
                     Headlights headlights, BigDecimal price) {
        super(color, maxSpeed, transmissionType, wheelRadiusType, wheels, gasolineTank, engine, electrics, headlights,
                price);
    }

    public boolean isCabrioletTopDown() {
        return isCabrioletTopDown;
    }

    public void cabrioletTopUp() {
        if (isCabrioletTopDown) {
            isCabrioletTopDown = false;
            System.out.println("Крыша кабриолета опущена");
        }
    }

    public void cabrioletTopDown() {
        if (!isCabrioletTopDown) {
            isCabrioletTopDown = true;
            System.out.println("Крыша кабриолета поднята");
        }
    }
}
