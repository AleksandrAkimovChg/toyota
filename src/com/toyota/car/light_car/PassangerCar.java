package com.toyota.car.light_car;

import com.toyota.car.Car;
import com.toyota.car.TransmissionType;
import com.toyota.component.Electrics;
import com.toyota.component.Engine;
import com.toyota.component.GasolineTank;
import com.toyota.component.Headlights;
import com.toyota.component.Wheel;
import com.toyota.component.WheelsRadiusType;

import java.math.BigDecimal;

public abstract class PassangerCar extends Car {
    protected boolean isCruiseControlOn = false;

    public PassangerCar(String color, int maxSpeed, TransmissionType transmissionType, WheelsRadiusType wheelRadiusType,
                        Wheel[] wheels, GasolineTank gasolineTank, Engine engine, Electrics electrics,
                        Headlights headlights, BigDecimal price) {
        super(color, maxSpeed, transmissionType, wheelRadiusType, wheels, gasolineTank, engine, electrics, headlights,
                price);
    }

    public boolean isCruiseControlOn() {
        return isCruiseControlOn;
    }

    public void cruiseControlOn() {
        if (!isCruiseControlOn) {
            isCruiseControlOn = true;
            System.out.println("Круиз контроль работает");
        }
    }

    public void cruiseControlOff() {
        if (isCruiseControlOn) {
            isCruiseControlOn = false;
            System.out.println("Круиз контроль выключен");
        }
    }
}
