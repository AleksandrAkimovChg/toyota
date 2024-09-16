package com.toyota.factory;

import com.toyota.car.cabriolet.model.Solara;
import com.toyota.car.cargo.model.Dyna;
import com.toyota.car.cargo.model.Hiance;
import com.toyota.car.light_car.model.Camry;
import com.toyota.component.WheelsRadiusType;
import com.toyota.car.TransmissionType;

import java.math.BigDecimal;

public class Conveyor {
    private static final int MAX_SPEED_SOLARA = 160;
    private static final int MAX_SPEED_CAMRY = 180;
    private static final int MAX_SPEED_HIANCE = 165;
    private static final int MAX_SPEED_DYNA = 175;
    private static final int MAX_GAS_CAPACITY_SOLARA = 50;
    private static final int MAX_GAS_CAPACITY_CAMRY = 60;
    private static final int MAX_GAS_CAPACITY_HIANCE = 90;
    private static final int MAX_GAS_CAPACITY_DYNA = 100;
    private static final int MAX_CAPACITY_CARGO = 2000;

    private final Country country;
    private Factory factory;

    public Conveyor(Country country, Factory factory) {
        this.country = country;
        this.factory = factory;
    }

    private void checkCountryFactory(Country country, Factory factory) throws CountyFactoryNotEqualException {
        if (this.factory != null) {
            if (this.country != this.factory.getCountry()) {
                throw new CountyFactoryNotEqualException("Ошибка страны поставщика: Конвеер в " + country
                        + ", а фабрика компонентов в " + factory.getCountry() + " . Создайте другой конвеер.");
            }
        }
    }

    public Camry createCamry(String color, BigDecimal price) throws CountyFactoryNotEqualException {
        checkCountryFactory(this.country, this.factory);
        Camry camry = new Camry(
                color,
                MAX_SPEED_CAMRY,
                TransmissionType.AUTOMATIC,
                factory.createTransmission(TransmissionType.AUTOMATIC),
                WheelsRadiusType.RADIUS_TYPE_17,
                factory.createFourWheels(WheelsRadiusType.RADIUS_TYPE_17),
                factory.createGasolineTank(MAX_GAS_CAPACITY_CAMRY),
                factory.createEngine(),
                factory.createElectrics(),
                factory.createHeadlights(),
                price
        );
        camry.setCountry(this.country);
        return camry;
    }

    public Solara createSolara(String color, BigDecimal price) throws CountyFactoryNotEqualException {
        checkCountryFactory(this.country, this.factory);
        Solara solara = new Solara(
                color,
                MAX_SPEED_SOLARA,
                TransmissionType.AMT,
                factory.createTransmission(TransmissionType.AMT),
                WheelsRadiusType.RADIUS_TYPE_16,
                factory.createFourWheels(WheelsRadiusType.RADIUS_TYPE_16),
                factory.createGasolineTank(MAX_GAS_CAPACITY_SOLARA),
                factory.createEngine(),
                factory.createElectrics(),
                factory.createHeadlights(),
                factory.createMiniFridge(),
                price
        );
        solara.setCountry(this.country);
        return solara;
    }

    public Hiance createHiance(String color, BigDecimal price) throws CountyFactoryNotEqualException {
        checkCountryFactory(this.country, this.factory);
        Hiance hiance = new Hiance(
                color,
                MAX_SPEED_HIANCE,
                TransmissionType.MANUAL,
                factory.createTransmission(TransmissionType.MANUAL),
                WheelsRadiusType.RADIUS_TYPE_20,
                factory.createFourWheels(WheelsRadiusType.RADIUS_TYPE_20),
                factory.createGasolineTank(MAX_GAS_CAPACITY_HIANCE),
                factory.createEngine(),
                factory.createElectrics(),
                factory.createHeadlights(),
                price,
                MAX_CAPACITY_CARGO,
                factory.createWheel(WheelsRadiusType.RADIUS_TYPE_20)
        );
        hiance.setCountry(this.country);
        return hiance;
    }

    public Dyna createDyna(String color, BigDecimal price) throws CountyFactoryNotEqualException {
        checkCountryFactory(this.country, this.factory);
        Dyna dyna = new Dyna(
                color,
                MAX_SPEED_DYNA,
                TransmissionType.MANUAL,
                factory.createTransmission(TransmissionType.MANUAL),
                WheelsRadiusType.RADIUS_TYPE_20,
                factory.createFourWheels(WheelsRadiusType.RADIUS_TYPE_20),
                factory.createGasolineTank(MAX_GAS_CAPACITY_DYNA),
                factory.createEngine(),
                factory.createElectrics(),
                factory.createHeadlights(),
                price,
                MAX_CAPACITY_CARGO
        );
        dyna.setCountry(this.country);
        return dyna;
    }
}
