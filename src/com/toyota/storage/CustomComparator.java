package com.toyota.storage;

import com.toyota.car.Car;

import java.util.Comparator;

public class CustomComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        int comparePrice = o1.getPrice().compareTo(o2.getPrice());
        if (comparePrice != 0) {
            return comparePrice;
        }
        return o1.equals(o2) ? 0 : 1;
    }
}
