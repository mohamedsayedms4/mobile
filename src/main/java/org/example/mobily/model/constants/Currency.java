package org.example.mobily.model.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Currency {
    USD("Dollar", "دولار"),
    EGP("Egyptian Pound", "جنيه");

    private final String en;
    private final String ar;

    Currency(String en, String ar) {
        this.en = en;
        this.ar = ar;
    }

    @JsonCreator
    public static Currency fromString(String value) {
        for (Currency c : Currency.values()) {
            if (c.name().equalsIgnoreCase(value)) {
                return c;
            }
        }
        throw new org.example.mobily.exceptions.InvalidCurrencyException(value);
    }

    public String getEn() { return en; }
    public String getAr() { return ar; }

}
