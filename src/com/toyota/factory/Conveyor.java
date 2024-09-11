package com.toyota.factory;

import com.toyota.car.cabriolet.model.Solara;
import com.toyota.car.cargo.model.Dyna;
import com.toyota.car.cargo.model.Hiance;
import com.toyota.car.light_car.model.Camry;
import com.toyota.component.WheelsRadiusType;
import com.toyota.car.TransmissionType;

import java.math.BigDecimal;

public class Conveyor {
    private static final int MAX_SPEED_160 = 160;
    private static final int MAX_SPEED_180 = 180;
    private static final int MAX_SPEED_165 = 165;
    private static final int MAX_SPEED_175 = 175;
    private static final int MAX_GAS_CAPACITY_50 = 50;
    private static final int MAX_GAS_CAPACITY_60 = 60;
    private static final int MAX_GAS_CAPACITY_90 = 90;
    private static final int MAX_GAS_CAPACITY_100 = 100;
    private static final int MAX_CAPACITY_2000 = 2000;

    private final Country country;
    private Factory factory;

    public Conveyor(Country country, Factory factory) {
        try {
            checkCountryFactory(country, factory);
        } catch (CountyFactoryNotEqualException ex) {
            ex.printStackTrace();
        }
        this.country = country;
        this.factory = factory;
    }

    private void checkCountryFactory(Country country, Factory factory) throws CountyFactoryNotEqualException {
        if (country != factory.getCountry()) {
            throw new CountyFactoryNotEqualException("Ошибка страны поставщика: Конвеер в " + country
                    + ", а фабрика компонентов в " + factory.getCountry() + " . Создайте другой конвеер.");
        }
    }

    public Camry createCamry(String color, BigDecimal price) {
        return new Camry(
                color,
                MAX_SPEED_180,
                TransmissionType.AUTOMATIC,
                factory.createTransmission(TransmissionType.AUTOMATIC),
                WheelsRadiusType.RADIUS_TYPE_17,
                factory.createFourWheels(WheelsRadiusType.RADIUS_TYPE_17),
                factory.createGasolineTank(MAX_GAS_CAPACITY_60),
                factory.createEngine(),
                factory.createElectrics(),
                factory.createHeadlights(),
                price);
    }

    public Solara createSolara(String color, BigDecimal price) {
        return new Solara(
                color,
                MAX_SPEED_160,
                TransmissionType.AMT,
                factory.createTransmission(TransmissionType.AMT),
                WheelsRadiusType.RADIUS_TYPE_16,
                factory.createFourWheels(WheelsRadiusType.RADIUS_TYPE_16),
                factory.createGasolineTank(MAX_GAS_CAPACITY_50),
                factory.createEngine(),
                factory.createElectrics(),
                factory.createHeadlights(),
                factory.createMiniFridge(),
                price);
    }

    public Hiance createHiance(String color, BigDecimal price) {
        return new Hiance(
                color,
                MAX_SPEED_165,
                TransmissionType.MANUAL,
                factory.createTransmission(TransmissionType.MANUAL),
                WheelsRadiusType.RADIUS_TYPE_20,
                factory.createFourWheels(WheelsRadiusType.RADIUS_TYPE_20),
                factory.createGasolineTank(MAX_GAS_CAPACITY_90),
                factory.createEngine(),
                factory.createElectrics(),
                factory.createHeadlights(),
                price,
                MAX_CAPACITY_2000,
                factory.createWheel(WheelsRadiusType.RADIUS_TYPE_20));
    }

    public Dyna createDyna(String color, BigDecimal price) {
        return new Dyna(
                color,
                MAX_SPEED_175,
                TransmissionType.MANUAL,
                factory.createTransmission(TransmissionType.MANUAL),
                WheelsRadiusType.RADIUS_TYPE_20,
                factory.createFourWheels(WheelsRadiusType.RADIUS_TYPE_20),
                factory.createGasolineTank(MAX_GAS_CAPACITY_100),
                factory.createEngine(),
                factory.createElectrics(),
                factory.createHeadlights(),
                price,
                MAX_CAPACITY_2000);
    }
}
