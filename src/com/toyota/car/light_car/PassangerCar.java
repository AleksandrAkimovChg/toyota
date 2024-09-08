package com.toyota.car.light_car;

import com.toyota.car.Car;
import com.toyota.car.TransmissionType;
import com.toyota.component.*;

import java.math.BigDecimal;

public abstract class PassangerCar extends Car {
    protected boolean isCruiseControlOn = false;

    public PassangerCar(String color, int maxSpeed, TransmissionType transmissionType, Transmission transmission,
                        WheelsRadiusType wheelRadiusType, Wheel[] wheels, GasolineTank gasolineTank, Engine engine,
                        Electrics electrics, Headlights headlights, BigDecimal price) {
        super(color, maxSpeed, transmissionType, transmission, wheelRadiusType, wheels, gasolineTank, engine, electrics,
                headlights, price);
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
