package com.toyota.dealer;

import com.toyota.car.Car;
import com.toyota.factory.Conveyor;
import com.toyota.factory.CountyFactoryNotEqualException;
import com.toyota.storage.CustomComparator;
import com.toyota.storage.Storage;

import java.math.BigDecimal;
import java.util.*;

public class Manager {
    private static final BigDecimal PRICE_CAMRY = new BigDecimal(10_000);
    private static final BigDecimal PRICE_SOLARA = new BigDecimal(12_000);
    private static final BigDecimal PRICE_HIACE = new BigDecimal(15_000);
    private static final BigDecimal PRICE_DYNA = new BigDecimal(22_000);

    private Storage storage;
    private Customer customer;
    private Conveyor conveyor;

    public Manager(Storage storage, Conveyor conveyor) {
        this.storage = storage;
        this.conveyor = conveyor;
    }

    public void welcomeCustomer(Customer customer) {
        if (customer.getMoney() != null) {
            System.out.println("Добро пожаловать в нашу дилерскую сеть " + customer.getName());
            this.customer = customer;
        }
        System.out.println("Сорян");
    }

    public Car soldCar(String color) throws CountyFactoryNotEqualException {
        BigDecimal money = this.customer.getMoney();
        if (this.storage.getCountStorage() <= 0) {
            Models model = getDealerModelMaxPrice(money);
            BigDecimal price = model.getDealerPrice();
            BigDecimal newPrice = price.add(price.movePointLeft(1));
            if (newPrice.compareTo(money) >= 0) {
                productionRequest(model, color, newPrice);
                return soldCarFromStorage(money);
            }
        }
        return soldCarFromStorage(money);
    }

    private Car soldCarFromStorage(BigDecimal money) {
        Map.Entry<Car, Models> carPrice = getCarMaxPrice(money);
        BigDecimal coast = carPrice.getKey().getPrice();
        Models model = carPrice.getValue();
        if (this.customer.getMoney().compareTo(coast) >= 0) {
            return getSoldCar(model);
        }
        return null;
    }

    private Car getSoldCar(Models model) {
        switch (model) {
            case CAMRY -> storage.getCamryFromStorage();
            case SOLARA -> storage.getSolaraFromStorage();
            case HIANCE -> storage.getHianceFromStorage();
            case DYNA -> storage.getDynaFromStorage();
        }
        return null;
    }

    private Models getDealerModelMaxPrice(BigDecimal money) {
        Models result = null;
        for (int i = 0; i < Models.values().length; i++) {
            Models model = Models.values()[i];
            if (money.compareTo(model.getDealerPrice()) >= 0) {
                result = model;
            }
        }
        return result;
    }

    private void productionRequest(Models model, String color, BigDecimal newPrice)
            throws CountyFactoryNotEqualException {
        switch (model) {
            case CAMRY -> storage.addCamry(conveyor.createCamry(color, newPrice));
            case SOLARA -> storage.addSolara(conveyor.createSolara(color, newPrice));
            case HIANCE -> storage.addHiance(conveyor.createHiance(color, newPrice));
            case DYNA -> storage.addDyna(conveyor.createDyna(color, newPrice));
        }
    }

    private Map.Entry<Car, Models> getCarMaxPrice(BigDecimal money) {
        Car car;
        Models model;
        TreeMap<Car, Models> result = new TreeMap<>(new CustomComparator().reversed());
        Map<Models, Car> stock = new HashMap<>(
                Map.of(
                        Models.CAMRY, storage.getCamryWithMaxPrice(),
                        Models.SOLARA, storage.getSolaraWithMaxPrice(),
                        Models.HIANCE, storage.getDynaWithMaxPrice(),
                        Models.DYNA, storage.getDynaWithMaxPrice()
                )
        );
        int count = 0;

        for (Map.Entry<Models, Car> item : stock.entrySet()) {
            if (money.compareTo(item.getValue().getPrice()) >= 0) {
                model = item.getKey();
                car = item.getValue();
                result.put(car, model);
            }
        }
        Map.Entry<Car, Models> carModelsEntry = result.firstEntry();
        return carModelsEntry;
    }
}
