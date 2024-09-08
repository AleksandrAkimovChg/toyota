package com.toyota.car.light_car.model;

import com.toyota.car.TransmissionType;
import com.toyota.car.light_car.PassangerCar;
import com.toyota.component.Electrics;
import com.toyota.component.Engine;
import com.toyota.component.GasolineTank;
import com.toyota.component.Headlights;
import com.toyota.component.Transmission;
import com.toyota.component.WheelsRadiusType;
import com.toyota.component.Wheel;

import java.math.BigDecimal;

public class Camry extends PassangerCar {
    private boolean isUsbOn = false;

    public Camry(String color, int maxSpeed, TransmissionType transmissionType, Transmission transmission,
                 WheelsRadiusType wheelRadiusType, Wheel[] wheels, GasolineTank gasolineTank, Engine engine,
                 Electrics electrics, Headlights headlights, BigDecimal price) {
        super(color, maxSpeed, transmissionType, transmission, wheelRadiusType, wheels, gasolineTank, engine, electrics,
                headlights, price);
    }

    public boolean isUsbOn() {
        return isUsbOn;
    }

    public void turnOnMusicInUsb() {
        if (!isUsbOn) {
            isUsbOn = true;
            System.out.println("Подключена музыка в USB");
        }
    }

    public void turnOffMusicInUsb() {
        if (isUsbOn) {
            isUsbOn = false;
            System.out.println("Выключена музыка из USB");
        }
    }
}
