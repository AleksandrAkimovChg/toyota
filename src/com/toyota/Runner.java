package com.toyota;

import com.toyota.car.cabriolet.model.Solara;
import com.toyota.car.cargo.model.Dyna;
import com.toyota.car.cargo.model.Hiance;
import com.toyota.car.light_car.model.Camry;
import com.toyota.component.Wheel;
import com.toyota.dealer.Customer;
import com.toyota.dealer.Manager;
import com.toyota.factory.Conveyor;
import com.toyota.factory.Country;
import com.toyota.factory.CountyFactoryNotEqualException;
import com.toyota.factory.Factory;
import com.toyota.storage.Storage;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {


        Storage storage = new Storage();
        Factory factoryJapan = new Factory(Country.JAPAN);
        Conveyor conveyor = new Conveyor(Country.JAPAN, factoryJapan);



        try {
            storage.addCamry(conveyor.createCamry("black", new BigDecimal(10000)));
            storage.addSolara(conveyor.createSolara("white", new BigDecimal(12000)));
            storage.addHiance(conveyor.createHiance("black", new BigDecimal(15000)));
            storage.addDyna(conveyor.createDyna("black", new BigDecimal(22000)));
        } catch (CountyFactoryNotEqualException ex) {
            System.out.println(ex);
        }

        Camry camryWithMaxPrice = storage.getCamryWithMaxPrice();
        Solara solaraWithMaxPrice = storage.getSolaraWithMaxPrice();
        Hiance hianceWithMaxPrice = storage.getHianceWithMaxPrice();
        Dyna dynaWithMaxPrice = storage.getDynaWithMaxPrice();

        Camry camryFromStorage = storage.getCamryFromStorage();
        Solara solaraFromStorage = storage.getSolaraFromStorage();
        Hiance hianceFromStorage = storage.getHianceFromStorage();
        Dyna dynaFromStorage = storage.getDynaFromStorage();

        boolean usbOn = camryFromStorage.isUsbOn();
        boolean miniFridgeOn = solaraFromStorage.isMiniFridgeOn();
        Wheel spareWheel = hianceFromStorage.getSpareWheel();
        boolean socketOutletOn = dynaFromStorage.isSocketOutletOn();


        System.out.println(storage);

        Customer customer = new Customer("Петрович", new BigDecimal(10000));
        Manager manager = new Manager(storage, conveyor);
        System.out.println(customer.getMoney());


    }
}
