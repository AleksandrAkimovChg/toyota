package com.toyota;

import com.toyota.car.StartCarException;
import com.toyota.car.TransmissionType;
import com.toyota.car.cabriolet.model.Solara;
import com.toyota.car.cargo.model.Dyna;
import com.toyota.car.cargo.model.Hiance;
import com.toyota.car.light_car.model.Camry;
import com.toyota.component.Electrics;
import com.toyota.component.Engine;
import com.toyota.component.GasolineTank;
import com.toyota.component.Headlights;
import com.toyota.component.Wheel;
import com.toyota.component.WheelsRadiusType;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {

        Wheel wheel1 = new Wheel(WheelsRadiusType.RADIUS_TYPE_17);
        Wheel wheel2 = new Wheel(WheelsRadiusType.RADIUS_TYPE_17);
        Wheel wheel3 = new Wheel(WheelsRadiusType.RADIUS_TYPE_17);
        Wheel wheel4 = new Wheel(WheelsRadiusType.RADIUS_TYPE_17);
        Wheel[] wheels = {wheel1, wheel2, wheel3, wheel4};

        Camry camry = new Camry("red", 180, TransmissionType.AUTOMATIC, WheelsRadiusType.RADIUS_TYPE_17,
                wheels, new GasolineTank(60), new Engine(), new Electrics(), new Headlights(),
                new BigDecimal("20000"));

        Wheel wheel5 = new Wheel(WheelsRadiusType.RADIUS_TYPE_16);
        Wheel wheel6 = new Wheel(WheelsRadiusType.RADIUS_TYPE_16);
        Wheel wheel7 = new Wheel(WheelsRadiusType.RADIUS_TYPE_16);
        Wheel wheel8 = new Wheel(WheelsRadiusType.RADIUS_TYPE_16);
        Wheel[] wells2 = {wheel5, wheel6, wheel7, wheel8};

        Solara solara1 = new Solara("blue", 160, TransmissionType.AMT, WheelsRadiusType.RADIUS_TYPE_16,
                wells2, new GasolineTank(50), new Engine(), new Electrics(), new Headlights(),
                new BigDecimal("15000"));

        Wheel wheel9 = new Wheel(WheelsRadiusType.RADIUS_TYPE_20);
        Wheel wheel10 = new Wheel(WheelsRadiusType.RADIUS_TYPE_20);
        Wheel wheel11 = new Wheel(WheelsRadiusType.RADIUS_TYPE_20);
        Wheel wheel12 = new Wheel(WheelsRadiusType.RADIUS_TYPE_20);
        Wheel[] wells3 = {wheel9, wheel10, wheel11, wheel12};
        Wheel wheel17 = new Wheel(WheelsRadiusType.RADIUS_TYPE_20);

        Hiance hiance1 = new Hiance("grey", 165, TransmissionType.MANUAL, WheelsRadiusType.RADIUS_TYPE_20,
                wells3, new GasolineTank(90), new Engine(), new Electrics(), new Headlights(),
                new BigDecimal("22000"), 2000, wheel17);

        Wheel wheel13 = new Wheel(WheelsRadiusType.RADIUS_TYPE_20);
        Wheel wheel14 = new Wheel(WheelsRadiusType.RADIUS_TYPE_20);
        Wheel wheel15 = new Wheel(WheelsRadiusType.RADIUS_TYPE_20);
        Wheel wheel16 = new Wheel(WheelsRadiusType.RADIUS_TYPE_20);
        Wheel[] wells4 = {wheel13, wheel14, wheel15, wheel16};

        Dyna dyna1 = new Dyna("white", 175, TransmissionType.MANUAL, WheelsRadiusType.RADIUS_TYPE_20,
                wells4, new GasolineTank(100), new Engine(), new Electrics(), new Headlights(),
                new BigDecimal("25000"), 3000);

        boolean cabrioletTopDown = solara1.isCabrioletTopDown();
        solara1.cabrioletTopDown();
        boolean cabrioletTopDown2 = solara1.isCabrioletTopDown();
        solara1.cabrioletTopUp();
        boolean cabrioletTopDown1 = solara1.isCabrioletTopDown();

        Wheel spareWheel = hiance1.getSpareWheel();
        Wheel spareWheel1 = hiance1.getSpareWheel();

        boolean socketOutletOn = dyna1.isSocketOutletOn();
        dyna1.setSocketOutletOn();
        boolean socketOutletOn1 = dyna1.isSocketOutletOn();
        dyna1.setSocketOutletOff();
        boolean socketOutletOn2 = dyna1.isSocketOutletOn();

        String color = camry.getColor();
        int maxSpeed = camry.getMaxSpeed();

        TransmissionType transmissionType = camry.getTransmissionType();
        String nameType = camry.getTransmissionType().getNameType();

        boolean isDrive1 = camry.isDrive();
        try {
            camry.drive();
        } catch (StartCarException ex) {
            System.out.println(ex.getMessage());
        }
        boolean isDrive2 = camry.isDrive();
        camry.stopDrive();
        boolean isDrive3 = camry.isDrive();

        WheelsRadiusType wheelRadiusType = camry.getCarWheelsRadiusType();
        int radius = camry.getCarWheelsRadiusType().getRadius();
        String typeName = camry.getCarWheelsRadiusType().getTypeName();

        GasolineTank gasolineTank = camry.getGasolineTank();
        int capacity = camry.getGasolineTank().getCapacity();
        int quantity1 = camry.getGasolineTank().getQuantity();
//        camry.getGasolineTank().setQuantity(100);
        camry.getGasolineTank().setQuantity(60);
        int quantity2 = camry.getGasolineTank().getQuantity();

        Engine engine1 = camry.getEngine();
        boolean engineFine1 = camry.getEngine().isEngineFine();
//        camry.getEngine().setEngineFine(false);
        boolean engineFine2 = camry.getEngine().isEngineFine();
        camry.setEngine(new Engine());
        Engine engine2 = camry.getEngine();
        
        Electrics electrics = camry.getElectrics();
        boolean electricsGood1 = camry.getElectrics().isElectricsGood();
//        camry.getElectrics().setElectricsGood(false);
        boolean electricsGood3 = camry.getElectrics().isElectricsGood();

        Headlights headlights = camry.getHeadlights();
        boolean headlightsGood1 = camry.getHeadlights().isHeadlightsGood();
//        camry.getHeadlights().setHeadlightsGood(false);
        boolean headlightsGood2 = camry.getHeadlights().isHeadlightsGood();

        BigDecimal price1 = camry.getPrice();
        camry.setPrice(new BigDecimal("123456789"));
        BigDecimal price2 = camry.getPrice();

        System.out.println(camry.isUsbOn());
        camry.turnOnMusicInUsb();
        camry.turnOffMusicInUsb();
        camry.cruiseControlOn();
        camry.cruiseControlOff();
        camry.headlightsOn();
    }
}
