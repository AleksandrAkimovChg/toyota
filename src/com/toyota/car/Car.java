package com.toyota.car;

import com.toyota.component.Electrics;
import com.toyota.component.Engine;
import com.toyota.component.GasolineTank;
import com.toyota.component.Headlights;
import com.toyota.component.Transmission;
import com.toyota.component.WheelsRadiusType;
import com.toyota.component.Wheel;
import com.toyota.factory.Country;

import java.math.BigDecimal;

public class Car {
    private final static int WHEEL_FRONT_LEFT_INDEX = 0;
    private final static int WHEEL_FRONT_RIGHT_INDEX = 1;
    private final static int WHEEL_REAR_LEFT_INDEX = 2;
    private final static int WHEEL_REAR_RIGHT_INDEX = 3;

    private final String color;
    private final int maxSpeed;
    protected final TransmissionType transmissionType;
    protected Transmission transmission;
    protected boolean isDrive = false;
    private final WheelsRadiusType carWheelsRadiusType;
    protected Wheel[] wheels;
    protected final GasolineTank gasolineTank;
    protected Engine engine;
    protected final Electrics electrics;
    private final Headlights headlights;
    private boolean isHeadLightsOn;
    private BigDecimal price;
    private Country country;

    public Car(String color, int maxSpeed, TransmissionType transmissionType, Transmission transmission,
               WheelsRadiusType wheelsRadiusType, Wheel[] wheels, GasolineTank gasolineTank, Engine engine,
               Electrics electrics, Headlights headlights, BigDecimal price) {

        if (wheels == null || wheels.length != 4) {
            throw new RuntimeException("Нет колес / недостаточно колес");
        }

        this.color = color;
        this.maxSpeed = maxSpeed;
        this.transmissionType = transmissionType;
        this.transmission = transmission;
        this.carWheelsRadiusType = wheelsRadiusType;
        this.wheels = new Wheel[wheels.length];
        this.wheels[WHEEL_FRONT_LEFT_INDEX] = setWheel(wheels[WHEEL_FRONT_LEFT_INDEX]);
        this.wheels[WHEEL_FRONT_RIGHT_INDEX] = setWheel(wheels[WHEEL_FRONT_RIGHT_INDEX]);
        this.wheels[WHEEL_REAR_LEFT_INDEX] = setWheel(wheels[WHEEL_REAR_LEFT_INDEX]);
        this.wheels[WHEEL_REAR_RIGHT_INDEX] = setWheel(wheels[WHEEL_REAR_RIGHT_INDEX]);
        this.gasolineTank = gasolineTank;
        this.engine = engine;
        this.electrics = electrics;
        this.headlights = headlights;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public boolean isDrive() {
        return isDrive;
    }

    public WheelsRadiusType getCarWheelsRadiusType() {
        return carWheelsRadiusType;
    }

    public Wheel setWheel(Wheel wheel) {
        if (getCarWheelsRadiusType() != wheel.getWheelRadiusType()) {
            throw new RuntimeException("Нельзя установить колесо. Неверный типоразмер");
        }
        return wheel;
    }

    public Wheel getWheelFrontLeft() {
        return wheels[WHEEL_FRONT_LEFT_INDEX];
    }

    public Wheel getWheelFrontRight() {
        return wheels[WHEEL_FRONT_RIGHT_INDEX];
    }

    public Wheel getWheelRearLeft() {
        return wheels[WHEEL_REAR_LEFT_INDEX];
    }

    public Wheel getWheelRearRight() {
        return wheels[WHEEL_REAR_RIGHT_INDEX];
    }

    public GasolineTank getGasolineTank() {
        return gasolineTank;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Electrics getElectrics() {
        return electrics;
    }

    public Headlights getHeadlights() {
        return headlights;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private boolean isWheelsGood() {
        int numberFaults = 0;
        numberFaults += getWheelFrontLeft() == null || getWheelFrontLeft().isFlat() ? 1 : 0;
        numberFaults += getWheelFrontRight() == null || getWheelFrontRight().isFlat() ? 1 : 0;
        numberFaults += getWheelRearLeft() == null || getWheelRearLeft().isFlat() ? 1 : 0;
        numberFaults += getWheelRearRight() == null || getWheelRearRight().isFlat() ? 1 : 0;
        return numberFaults <= 0;
    }

    public void drive() throws StartCarException {
        if (!isDrive) {
            if (!isWheelsGood()) {
                throw new StartCarException("Колеса неисправны");
            }
            if (gasolineTank.getQuantity() <= 0) {
                throw new StartCarException("Бензина нет");
            }
            if (!electrics.isElectricsGood()) {
                throw new StartCarException("Электрика неисправна");
            }
            if (!engine.isEngineFine()) {
                throw new StartCarException("Двигатель неисправен");
            }
            isDrive = true;
            System.out.println("Машина едет");
        }
    }

    public void stopDrive() {
        if (isDrive) {
            isDrive = false;
        }
    }

    public void headlightsOn() {
        if (!headlights.isHeadlightsGood()) {
            throw new RuntimeException("Фары неисправны");
        }
        if (!isHeadLightsOn) {
            isHeadLightsOn = true;
            System.out.println("Фары светят");
        }
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
