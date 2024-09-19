package com.toyota.component;

public abstract class Component {
    private boolean isWorkable;

    public Component(boolean workable) {
        this.isWorkable = workable;
    }

    public boolean isWorkable() {
        return isWorkable;
    }

    public void setWorkable(boolean workable) {
        isWorkable = workable;
    }
}
