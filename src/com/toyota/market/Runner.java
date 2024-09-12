package com.toyota.market;

import com.toyota.car.StartCarException;
import com.toyota.car.cabriolet.model.Solara;
import com.toyota.car.cargo.model.Dyna;
import com.toyota.car.cargo.model.Hiance;
import com.toyota.car.light_car.model.Camry;
import com.toyota.factory.Conveyor;
import com.toyota.factory.Country;
import com.toyota.factory.Factory;
import com.toyota.storage.Storage;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {


        Storage storage = new Storage();
        Factory factoryJapan = new Factory(Country.JAPAN);
        Conveyor conveyor = new Conveyor(Country.JAPAN, factoryJapan);
        Camry camry = conveyor.createCamry("black", new BigDecimal(10000));
        Solara solara = conveyor.createSolara("white", new BigDecimal(12000));
        Hiance hiance = conveyor.createHiance("black", new BigDecimal(15000));
        Dyna dyna = conveyor.createDyna("black", new BigDecimal(22000));
        storage.addCamry(camry);
        storage.addSolara(solara);
        storage.addHiance(hiance);
        storage.addDyna(dyna);
        System.out.println(storage);


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

        Customer customer = new Customer("Петрович", new BigDecimal(10000));
        System.out.println(customer.getMoney());


    }
}
