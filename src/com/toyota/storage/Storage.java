package com.toyota.storage;

import com.toyota.car.Car;
import com.toyota.car.cabriolet.model.Solara;
import com.toyota.car.cargo.model.Dyna;
import com.toyota.car.cargo.model.Hiance;
import com.toyota.car.light_car.model.Camry;
import com.toyota.dealer.Models;

import java.util.*;

import static com.toyota.dealer.Models.*;

public class Storage {
    private int count;
    private final int maxCapacity = 1000;
    private int freePlace;
    private final Map<Models, List<Car>> cars;

    public Storage() {
        this.count = 0;
        this.freePlace = this.maxCapacity - this.count;
        this.cars = new HashMap<>();
    }

    /**
     * Проверяем свободное место на складе.
     */
    private boolean checkFreePlace() {
        return freePlace > 0;
    }

    private void addCounting() {
        count++;
        freePlace--;
    }

    /**
     * Добавляем экземпляр Camry в мапу.
     */
    public boolean addCamry(Camry camry) {
        if (checkFreePlace() && camry instanceof Camry) {
            if (cars.get(CAMRY) == null) {
                cars.put(CAMRY, cars.getOrDefault(CAMRY, new ArrayList<>(List.of(camry))));
            } else {
                List<Car> carList = cars.get(CAMRY);
                carList.add(camry);
                cars.put(CAMRY, carList);
                return true;
            }
            addCounting();
        }
        return false;
    }

    /**
     * Добавляем экземпляр Solara в мапу.
     */
    public boolean addSolara(Solara solara) {
        if (checkFreePlace() && solara instanceof Solara) {
            addCounting();
            if (cars.get(SOLARA) == null) {
                cars.put(SOLARA, cars.getOrDefault(SOLARA, new ArrayList<>(List.of(solara))));
            } else {
                List<Car> carList = cars.get(SOLARA);
                carList.add(solara);
                cars.put(SOLARA, cars.get(SOLARA));
                return true;
            }
        }
        return false;
    }

    /**
     * Добавляем экземпляр Hiance в мапу.
     */
    public boolean addHiance(Hiance hiance) {
        if (checkFreePlace() && hiance instanceof Hiance) {
            addCounting();
            if (cars.get(HIANCE) == null) {
                cars.put(HIANCE, cars.getOrDefault(HIANCE, new ArrayList<>(List.of(hiance))));
            } else {
                List<Car> carList = cars.get(HIANCE);
                cars.put(HIANCE, carList);
                addCounting();
                return true;
            }
        }
        return false;
    }

    /**
     * Добавляем экземпляр Dyna в мапу.
     */
    public boolean addDyna(Dyna dyna) {
        if (checkFreePlace() && dyna instanceof Dyna) {
            addCounting();
            if (cars.get(DYNA) == null) {
                cars.put(DYNA, new ArrayList<>(List.of(dyna)));
                cars.put(DYNA, cars.getOrDefault(DYNA, new ArrayList<>(List.of(dyna))));
            } else {
                List<Car> carList = cars.get(DYNA);
                carList.add(dyna);
                cars.put(DYNA, carList);
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращаем лист с сортировкой по убыванию. Лист получен по модели.
     */
    private List<Car> getReversSortedCarList(Models model) {
        List<Car> carList = cars.get(model);
        carList.sort(new CustomComparator().reversed());
        return carList;
    }

    /**
     * Возвращаем первый (максимальный) элемент из списка по модели Camry.
     */
    public Camry getCamryWithMaxPrice() {
        return (Camry) getReversSortedCarList(CAMRY).get(0);
    }

    /**
     * Выбытие модели из хранения.
     */
    public Camry getCamryFromStorage(Car camry) {
        List<Car> carList = getReversSortedCarList(CAMRY);
        carList.remove(camry);
        if (!carList.contains(camry)) {
            outCounting();
            return (Camry) camry;
        }
        return null;
    }

    /**
     * Возвращаем первый (максимальный) элемент из списка по модели Solara.
     */
    public Solara getSolaraWithMaxPrice() {
        return (Solara) getReversSortedCarList(SOLARA).get(0);
    }

    /**
     * Выбытие модели solara из хранения.
     */
    public Solara getSolaraFromStorage(Car solara) {
        List<Car> carList = getReversSortedCarList(SOLARA);
        carList.remove(solara);
        if (!carList.contains(solara)) {
            outCounting();
            return (Solara) solara;
        }
        return null;
    }

    /**
     * Возвращаем первый (максимальный) элемент из списка по модели Hiance.
     */
    public Hiance getHianceWithMaxPrice() {
        return (Hiance) getReversSortedCarList(HIANCE).get(0);
    }

    /**
     * Выбытие модели hiance из хранения.
     */
    public Hiance getHianceFromStorage(Car hiance) {
        List<Car> carList = getReversSortedCarList(HIANCE);
        carList.remove(hiance);
        if (!carList.contains(hiance)) {
            outCounting();
            return (Hiance) hiance;
        }
        return null;
    }

    /**
     * Возвращаем первый (максимальный) элемент из списка по модели Dyna.
     */
    public Dyna getDynaWithMaxPrice() {
        return (Dyna) getReversSortedCarList(DYNA).get(0);
    }

    /**
     * Выбытие модели dyna из хранения.
     */
    public Dyna getDynaFromStorage(Car dyna) {
        List<Car> carList = getReversSortedCarList(DYNA);
        carList.remove(dyna);
        if (!carList.contains(dyna)) {
            outCounting();
            return (Dyna) dyna;
        }
        return null;
    }

    /**
     * Счетчик заполнения хранилища.
     */
    public int getCountStorage() {
        return count;
    }

    /**
     * Корректируем счетчики при выбытии модели.
     */
    private void outCounting() {
        count--;
        freePlace++;
    }

    public Map<Models, List<Car>> getCars() {
        return cars;
    }
}
