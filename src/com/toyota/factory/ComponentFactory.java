package com.toyota.factory;

import com.toyota.car.TransmissionType;
import com.toyota.component.Electrics;
import com.toyota.component.Engine;
import com.toyota.component.GasolineTank;
import com.toyota.component.Headlights;
import com.toyota.component.MiniFridge;
import com.toyota.component.Transmission;
import com.toyota.component.WheelsRadiusType;
import com.toyota.component.Wheel;

public class ComponentFactory {
    private final Country country;

    public ComponentFactory(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    protected Transmission createTransmission(TransmissionType transmissionType) {
        return new Transmission(transmissionType, true);
    }

    protected Electrics createElectrics() {
        return new Electrics(true);
    }


    protected Engine createEngine() {
        return new Engine(true);
    }

    protected GasolineTank createGasolineTank(int quantity, int capacity) {
        return new GasolineTank(0, 60);
    }

    protected Headlights createHeadlights() {
        return new Headlights(true);
    }

    protected MiniFridge createMiniFridge() {
        return new MiniFridge();
    }

    protected Wheel createWheel(WheelsRadiusType wheelRadiusType) {
        return new Wheel(wheelRadiusType);
    }

    protected Wheel[] createFourWheel(WheelsRadiusType wheelRadiusType) {
        Wheel[] wheels = new Wheel[4];
        wheels[0] = createWheel(wheelRadiusType);
        wheels[1] = createWheel(wheelRadiusType);
        wheels[2] = createWheel(wheelRadiusType);
        wheels[3] = createWheel(wheelRadiusType);
        return wheels;
    }
}
