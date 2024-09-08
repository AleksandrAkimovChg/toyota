package com.toyota.factory;

import com.toyota.car.cabriolet.model.Solara;
import com.toyota.car.cargo.model.Dyna;
import com.toyota.car.cargo.model.Hiance;
import com.toyota.car.light_car.model.Camry;

public class CountyFactoryNotEqualException extends Exception {
    public CountyFactoryNotEqualException(String message) {
        super(message);
    }
}
