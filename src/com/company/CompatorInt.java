package com.company;

import java.util.Comparator;

public class CompatorInt implements Comparator<Country> {

    @Override
    public int compare(Country o1, Country o2 ) {
        return o1.getNameCountry().compareTo(o2.getNameCountry());
    }
}
