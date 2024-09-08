package com.toyota.component;

public class Headlights {
    private boolean isHeadlightsGood;

    public Headlights(boolean isHeadlightsGood) {
        this.isHeadlightsGood = isHeadlightsGood;
    }

    public boolean isHeadlightsGood() {
        return isHeadlightsGood;
    }

    public void setHeadlightsGood(boolean bool) {
        isHeadlightsGood = bool;
    }
}
