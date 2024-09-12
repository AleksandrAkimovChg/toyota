package com.toyota.storage;

import com.toyota.car.cabriolet.model.Solara;
import com.toyota.car.cargo.model.Dyna;
import com.toyota.car.cargo.model.Hiance;
import com.toyota.car.light_car.model.Camry;

import java.util.LinkedList;

public class Storage {
    private int count;
    private final int maxCapacity = 1000;
    private int freePlace;

    private LinkedList<Camry> camrys;
    private LinkedList<Solara> solaras;
    private LinkedList<Hiance> hiances;
    private LinkedList<Dyna> dynas;

    public Storage() {
        this.count = 0;
        this.freePlace = this.maxCapacity - this.count;
        camrys = new LinkedList<>();
        solaras = new LinkedList<>();
        hiances = new LinkedList<>();
        dynas = new LinkedList<>();
    }

    private boolean checkFreePlace() {
        return freePlace > 0;
    }

    public void addCamry(Camry camry) {
        if (checkFreePlace()) {
            camrys.add(camry);
            count++;
            freePlace--;
        }
    }

    public void addSolara(Solara solara) {
        if (checkFreePlace()) {
            solaras.add(solara);
            count++;
            freePlace--;
        }
    }

    public void addHiance(Hiance hiance) {
        if (checkFreePlace()) {
            hiances.add(hiance);
            count++;
            freePlace--;
        }

    }

    public void addDyna(Dyna dyna) {
        if (checkFreePlace()) {
            dynas.add(dyna);
            count++;
            freePlace--;
        }
    }

    public Camry getCamry() {
        count--;
        freePlace++;
        return camrys.removeLast();
    }

    public Solara getSolara() {
        count--;
        freePlace++;
        return solaras.removeLast();
    }

    public Hiance getHiance() {
        count--;
        freePlace++;
        return hiances.removeLast();
    }

    public Dyna getDyna() {
        count--;
        freePlace++;
        return dynas.removeLast();
    }

    public int getCountCamrys() {
        count--;
        freePlace++;
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

    public int getCount() {
        return count;
    }
}
