package com.toyota.storage;

import com.toyota.car.Car;
import com.toyota.car.cabriolet.model.Solara;
import com.toyota.car.cargo.model.Dyna;
import com.toyota.car.cargo.model.Hiance;
import com.toyota.car.light_car.model.Camry;

import java.util.*;

public class Storage {
    private int count;
    private final int maxCapacity = 1000;
    private int freePlace;
    private TreeSet<Camry> camrys;
    private TreeSet<Solara> solaras;
    private TreeSet<Hiance> hiances;
    private TreeSet<Dyna> dynas;

    public Storage() {
        this.count = 0;
        this.freePlace = this.maxCapacity - this.count;
        camrys = new TreeSet<>(new CustomComparator().reversed());
        solaras = new TreeSet<>(new CustomComparator().reversed());
        hiances = new TreeSet<>(new CustomComparator().reversed());
        dynas = new TreeSet<>(new CustomComparator().reversed());
    }

    public Comparator<Car> compareCar = (arg1, arg2) -> {
        int comparePrice = arg1.getPrice().compareTo(arg2.getPrice());
        if (comparePrice != 0) {
            return comparePrice;
        }
        return arg1.equals(arg2) ? 0 : 1;
    };

    private boolean checkFreePlace() {
        return freePlace > 0;
    }

    private void addCounting() {
        count++;
        freePlace--;
    }

    public boolean addCamry(Camry camry) {
        if (checkFreePlace()) {
            camrys.add(camry);
            addCounting();
            return true;
        }
        return false;
    }

    public boolean addSolara(Solara solara) {
        if (checkFreePlace()) {
            solaras.add(solara);
            addCounting();
            return true;
        }
        return false;
    }

    public boolean addHiance(Hiance hiance) {
        if (checkFreePlace()) {
            hiances.add(hiance);
            addCounting();
            return true;
        }
        return false;
    }

    public boolean addDyna(Dyna dyna) {
        if (checkFreePlace()) {
            dynas.add(dyna);
            addCounting();
            return true;
        }
        return false;
    }

    public Camry getCamryWithMaxPrice() {
        return camrys.first();
    }

    private void outCounting() {
        count--;
        freePlace++;
    }

    public Camry getCamryFromStorage() {
        outCounting();
        return camrys.pollFirst();
    }

    public Solara getSolaraWithMaxPrice() {
        return solaras.first();
    }

    public Solara getSolaraFromStorage() {
        outCounting();
        return solaras.pollFirst();
    }

    public Hiance getHianceWithMaxPrice() {
        return hiances.first();
    }

    public Hiance getHianceFromStorage() {
        outCounting();
        return hiances.pollFirst();
    }

    public Dyna getDynaWithMaxPrice() {
        return dynas.first();
    }

    public Dyna getDynaFromStorage() {
        outCounting();
        return dynas.pollFirst();
    }

    public int getCountCamrys() {
        return camrys.size();
    }

    public int getCountSolaras() {
        return solaras.size();
    }

    public int getCountHiances() {
        return hiances.size();
    }

    public int getCountDynas() {
        return dynas.size();
    }

    public int getCountStorage() {
        return count;
    }
}
