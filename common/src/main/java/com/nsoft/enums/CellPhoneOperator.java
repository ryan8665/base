package com.nsoft.enums;

public enum CellPhoneOperator {
    MCI("MCI"),
    IRANCELL("IranCell"),
    RIGHTEL("Rightel");

    private String name;

    CellPhoneOperator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
