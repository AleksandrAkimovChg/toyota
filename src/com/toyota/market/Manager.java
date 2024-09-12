package com.toyota.market;

import com.toyota.storage.Storage;

public class Manager {
    private final Storage storage;

    public Manager(Storage storage) {
        this.storage = storage;
    }

    public void welcomeCustomer(Customer customer) {
        System.out.println("Добро пожаловать в нашу дилерскую сеть " + customer.getName());
    }

    public void offer(Customer customer) {
        customer.getMoney();
    }
}
