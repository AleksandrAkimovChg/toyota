package com.toyota;

import com.toyota.car.Car;
import com.toyota.dealer.Cashier;
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
            System.out.println(ex.getMessage());
        }

//        Camry camryWithMaxPrice = storage.getCamryWithMaxPrice();
//        Solara solaraWithMaxPrice = storage.getSolaraWithMaxPrice();
//        Hiance hianceWithMaxPrice = storage.getHianceWithMaxPrice();
//        Dyna dynaWithMaxPrice = storage.getDynaWithMaxPrice();
//
//        Camry camryFromStorage = storage.getCamryFromStorage(camryWithMaxPrice);
//        Solara solaraFromStorage = storage.getSolaraFromStorage(solaraWithMaxPrice);
//        Hiance hianceFromStorage = storage.getHianceFromStorage(hianceWithMaxPrice);
//        Dyna dynaFromStorage = storage.getDynaFromStorage(dynaWithMaxPrice);
//
//        boolean usbOn = camryFromStorage.isUsbOn();
//        boolean miniFridgeOn = solaraFromStorage.isMiniFridgeOn();
//        Wheel spareWheel = hianceFromStorage.getSpareWheel();
//        boolean socketOutletOn = dynaFromStorage.isSocketOutletOn();


        System.out.println(storage);

        Manager manager = new Manager("Salvatore", storage, conveyor);
        Customer customer1 = new Customer("Петрович", new BigDecimal(10000));
        Car car1 = manager.welcomeCustomer(customer1);
        Cashier.order(car1);

        Customer customer2 = new Customer("Василич", new BigDecimal(12000));
        Car car2 = manager.welcomeCustomer(customer2);
        Cashier.order(car2);

        Customer customer3 = new Customer("Иваныч", new BigDecimal(15000));
        Car car3 = manager.welcomeCustomer(customer3);
        Cashier.order(car3);

        Customer customer4 = new Customer("Семеныч", new BigDecimal(22000));
        Car car4 = manager.welcomeCustomer(customer4);
        Cashier.order(car4);

        Customer customer5 = new Customer("Саныч", new BigDecimal(11000));
        Car car5 = manager.welcomeCustomer(customer5);
        Cashier.order(car5);

        Customer customer6 = new Customer("Виталич", new BigDecimal(13200));
        Car car6 = manager.welcomeCustomer(customer6);
        Cashier.order(car6);

        Customer customer7 = new Customer("Димыч", new BigDecimal(8000));
        Car car7 = manager.welcomeCustomer(customer7);
        Cashier.order(car7);

        Customer customer8 = new Customer("Жекич", new BigDecimal(30000));
        Car car8 = manager.welcomeCustomer(customer8);
        Cashier.order(car8);

        Cashier.printIncome();
        manager.createReport();
    }
}
