package com.toyota.component;

import com.toyota.car.TransmissionType;

public class Transmission extends Component {
    private final TransmissionType transmissionType;

    public Transmission(TransmissionType transmissionType, boolean workable) {
        super(workable);
        this.transmissionType = transmissionType;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }
}
