package com.buchdemo.buchcontrol.model;

import java.util.ArrayList;
import java.util.List;

public enum Buchtyp {

    ABENTEUER("Abenteuer"),
    HORROR("Horror"),
    KINDERBUCH("Kinderbuch"),
    THRILLER("Thriller"),
    LIEBESROMAN("Liebesroman"),
    SCIENCEFICTION("Scifi"),
    SACHBUCH("Sachbuch"),
    FACHBUCH("Fachbuch"),
    KOCHEN("Kochen"),
    FAMILIE("Familie"),
    UNKATEGORISIERT("Unkategorrisiert");

    private String test;

    Buchtyp(String test) {
        this.test = test;
    }

    public String getTest() {
        return this.test;
    }

    public static Buchtyp fromString(String typ) {
        for (Buchtyp bt : Buchtyp.values()) {
            if (bt.test.equalsIgnoreCase(typ)) {
                return bt;
            }
        }
        return null;
    }

    public static List<String> getAllStrings() {
        ArrayList<String> buchString = new ArrayList();
        for (Buchtyp bt : Buchtyp.values()) {
                buchString.add(bt.test);
        }
        return buchString;
    }
}
