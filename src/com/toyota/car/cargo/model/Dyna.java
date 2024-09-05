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

public class Dyna extends Cargo {
    private boolean socketOutletOn;

    public Dyna(String color, int maxSpeed, TransmissionType transmissionType, WheelsRadiusType wheelRadiusType,
                Wheel[] wheels, GasolineTank gasolineTank, Engine engine, Electrics electrics, Headlights headlights,
                BigDecimal price, int kilogramme) {
        super(color, maxSpeed, transmissionType, wheelRadiusType, wheels, gasolineTank, engine, electrics, headlights,
                price, kilogramme);
    }

    public boolean isSocketOutletOn() {
        return socketOutletOn;
    }

    public void setSocketOutletOn() {
        if (!socketOutletOn) {
            this.socketOutletOn = true;
            System.out.println("В розетку подключено устройство");
        }
    }

    public void setSocketOutletOff() {
        if (socketOutletOn) {
            this.socketOutletOn = false;
            System.out.println("Из розетки выключено устройство");
        }
    }
}
