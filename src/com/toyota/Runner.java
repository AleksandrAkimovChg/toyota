package com.toyota;

import com.toyota.car.StartCarException;
import com.toyota.car.cabriolet.model.Solara;
import com.toyota.car.cargo.model.Dyna;
import com.toyota.car.cargo.model.Hiance;
import com.toyota.car.light_car.model.Camry;
import com.toyota.factory.Conveyor;
import com.toyota.factory.Country;
import com.toyota.factory.Factory;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {

        Factory factoryHk = new Factory(Country.CHINA);
        Factory factoryRu = new Factory(Country.RUSSIA);
        Conveyor conveyor = new Conveyor(Country.RUSSIA, factoryRu);
        Camry camry = conveyor.createCamry("red", new BigDecimal(20000));
        Solara solara = conveyor.createSolara("blue", new BigDecimal(15000));
        Hiance hiance = conveyor.createHiance("green", new BigDecimal(25000));
        Dyna dyna = conveyor.createDyna("orange", new BigDecimal(30000));

        System.out.println(camry.isDrive());
//        try {
//            camry.drive();
//        } catch (StartCarException ex) {
//            ex.printStackTrace();
//        }
        System.out.println(camry.isDrive());
        camry.getGasolineTank().setQuantity(50);
        try {
            camry.drive();
        } catch (StartCarException ex) {
            ex.printStackTrace();
        }
        System.out.println(camry.isDrive());


    }
}
