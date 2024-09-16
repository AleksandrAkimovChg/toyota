package com.toyota.dealer;

import com.toyota.car.Car;
import com.toyota.car.cabriolet.model.Solara;
import com.toyota.car.cargo.model.Dyna;
import com.toyota.car.cargo.model.Hiance;
import com.toyota.car.light_car.model.Camry;
import com.toyota.factory.Conveyor;
import com.toyota.factory.Country;
import com.toyota.factory.CountyFactoryNotEqualException;
import com.toyota.factory.Factory;
import com.toyota.storage.Storage;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.TreeSet;

public class Runner {
    public static void main(String[] args) {


        Storage storage = new Storage();
        Factory factoryJapan = new Factory(Country.JAPAN);



        try {

            Comparator<Car> compareReview = (arg1, arg2) -> {
                if (arg1.getPrice().compareTo(arg2.getPrice()) != 0) {
                    return arg1.getPrice().compareTo(arg2.getPrice());
                }
                return arg1.equals(arg2) ? 0 : 1;
            };
            TreeSet<Camry> camryQ = new TreeSet<>(compareReview.reversed());

            Conveyor conveyor = new Conveyor(Country.JAPAN, factoryJapan);

            Camry camry1 = conveyor.createCamry("black", new BigDecimal(10000));
            camryQ.add(camry1);
            camryQ.add(camry1);
            Camry camry2 = conveyor.createCamry("black", new BigDecimal(10000));
            camryQ.add(camry2);

//            camryQ.add(conveyor.createCamry("black", new BigDecimal(10000)));
//            camryQ.add(conveyor.createCamry("black", new BigDecimal(10000)));
//            camryQ.add(conveyor.createCamry("black", new BigDecimal(10001)));
//            camryQ.add(conveyor.createCamry("black", new BigDecimal(10002)));
//            camryQ.add(conveyor.createCamry("black", new BigDecimal(10003)));


            System.out.println(camryQ);


            Camry camry = conveyor.createCamry("black", new BigDecimal(10000));
            storage.addCamry(camry);
            Solara solara = conveyor.createSolara("white", new BigDecimal(12000));
            storage.addSolara(solara);
            Hiance hiance = conveyor.createHiance("black", new BigDecimal(15000));
            storage.addHiance(hiance);
            Dyna dyna = conveyor.createDyna("black", new BigDecimal(22000));
            storage.addDyna(dyna);
        } catch (CountyFactoryNotEqualException ex) {
            System.out.println(ex);
        }

        System.out.println(storage);

        Customer customer = new Customer("Петрович", new BigDecimal(10000));
        System.out.println(customer.getMoney());


    }
}
