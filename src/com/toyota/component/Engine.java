package com.toyota.component;

public class Engine {
    private boolean isEngineFine;

    public Engine(boolean isEngineFine) {
        this.isEngineFine = isEngineFine;
    }

    public boolean isEngineFine() {
        return isEngineFine;
    }

    public void setEngineFine(boolean bool) {
        isEngineFine = bool;
    }
}
