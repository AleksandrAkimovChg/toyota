package com.toyota.component;

public class GasolineTank {
    private int quantity;
    private final int capacity;

    public GasolineTank(int capacity) {
        this.quantity = 0;
        this.capacity = capacity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (capacity < quantity) {
            throw new RuntimeException("Вместимость меньше заправочного объема");
        }
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public int getCapacity() {
        return capacity;
    }
}
