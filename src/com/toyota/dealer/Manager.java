package com.toyota.dealer;

import com.toyota.car.Car;
import com.toyota.factory.Conveyor;
import com.toyota.factory.CountyFactoryNotEqualException;
import com.toyota.storage.CustomComparator;
import com.toyota.storage.Storage;

import java.math.BigDecimal;
import java.util.*;

public class Manager {
    private final String name;
    private final Storage storage;
    private final Conveyor conveyor;
    private Customer customer;
    private Report report;

    public Manager(String name, Storage storage, Conveyor conveyor) {
        this.name = name;
        this.storage = storage;
        this.conveyor = conveyor;
        this.report = new Report(this.name);
    }

    public Car welcomeCustomer(Customer customer) {
        if (customer.getMoney() != null) {
            System.out.println("Добро пожаловать в нашу дилерскую сеть " + customer.getName());
            this.customer = customer;
            return soldCar();
        }
        return null;
    }

    public Car soldCar() {
        BigDecimal money = this.customer.getMoney();
        if (this.storage.getCountStorage() <= 0) {
            Models model = getDealerModelMaxPrice(money);
            if (model != null) {
                BigDecimal price = model.getDealerPrice();
                BigDecimal newPrice = price.add(price.movePointLeft(1));
                if (money.compareTo(newPrice) >= 0) {
                    try {
                        productionRequest(model, "magenta", newPrice);
                    } catch (CountyFactoryNotEqualException ex) {
                        System.out.println(ex.getMessage());
                    }
                    return soldCarFromStorage(money);
                }
            }
            System.out.println("денежек маловато");
            return null;
        }
        return soldCarFromStorage(money);
    }

    private Car soldCarFromStorage(BigDecimal money) {
        Map.Entry<Models, Car> modelsCarEntry = getCarMaxPrice(money).firstEntry();
        Car car = modelsCarEntry.getValue();
        BigDecimal coast = modelsCarEntry.getValue().getPrice();
        Models model = modelsCarEntry.getKey();
        if (this.customer.getMoney().compareTo(coast) >= 0) {
            this.report.addReport(model, car);
            return getSoldCar(model, car);
        }
        return null;
    }

    private Car getSoldCar(Models model, Car car) {
        switch (model) {
            case CAMRY -> {
                return storage.getCamryFromStorage(car);
            }
            case SOLARA -> {
                return storage.getSolaraFromStorage(car);
            }
            case HIANCE -> {
                return storage.getHianceFromStorage(car);
            }
            case DYNA -> {
                return storage.getDynaFromStorage(car);
            }
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

    private TreeMap<Models, Car> getCarMaxPrice(BigDecimal money) {
        reversSortStockList();
        Map<Models, List<Car>> stock = storage.getCars();
        Models modelResult = null;
        Car carResult = null;
        for (Map.Entry<Models, List<Car>> item : stock.entrySet()) {
            List<Car> cars = item.getValue();
            Car car;
            Models model;
            if (!cars.isEmpty() && cars.size() > 0) {
                model = item.getKey();
                car = item.getValue().get(0);
                if (car != null && money.compareTo(car.getPrice()) >= 0) {
                    money = car.getPrice();
                    modelResult = model;
                    carResult = car;
                }
            }

        }
        TreeMap<Models, Car> result = new TreeMap<>();
        result.put(modelResult, carResult);
        return result;
    }

    private void reversSortStockList() {
        Map<Models, List<Car>> cars = storage.getCars();
        for (Models item : Models.values()) {
            Collections.sort(cars.get(item), new CustomComparator().reversed());
        }
    }

    public void createReport() {
        report.doReport();
    }
}
