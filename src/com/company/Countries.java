package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Countries implements Serializable {
    @JsonProperty("countries")
    ArrayList<Country> countries;

    public Countries() {
        countries = new ArrayList<>();
    }

    void add(Country country) {
        this.countries.add(country);
    }

    void removePopulation(int countPopulation) throws IOException {
        for (Country object : countries) {
            if (object.getPopulation() < countPopulation) {
                countries.remove(object);
                break;
            }
        }
        Main.menu();
    }

    void searchCapital(String capital) throws IOException {
        for (Country object : countries) {
            if (object.getCapital().equals(capital)) {
                System.out.println(object);
            }
        }
        Main.menu();
    }

    void searchArea(int area) throws IOException {
        for (Country object : countries) {
            if (object.getArea() == area) {
                System.out.println(object);
            }
        }
        Main.menu();
    }

    void sorting() throws IOException {
        Collections.sort(countries, new CompatorInt());
        Main.menu();
    }

    void saveFile(String fileName) throws IOException {
        FileManager saveBase = new FileManager();
        saveBase.save(countries, fileName);
    }

    void loadFile(String fileName) throws IOException {
        FileManager loadBase = new FileManager();
        loadBase.load(countries, fileName);
    }

    void serializeSaveFile(String fileName) throws IOException {
        FileManager saveBase = new FileManager();
        saveBase.serialize(this.countries, fileName);
    }

    void deSerializeLoadFile(String fileName) throws IOException {
        FileManager loadBase = new FileManager();
        this.countries = loadBase.deserialize(countries, fileName);
    }

    void loadJacksonDeSerialize(String fileName) throws IOException {
        FileManager loadBase = new FileManager();
        this.countries = loadBase.jacksonDeSerialize(countries, fileName);

    }

    void saveJacksonSerializeSaveFile(String fileName) throws IOException {
        FileManager saveBase = new FileManager();
        saveBase.jacksonSerialize(this, fileName);
        countries.clear();
    }


    @Override
    public String toString() {
        return "Countries{" +
                "countries=\n" + countries +
                '}';
    }


}
