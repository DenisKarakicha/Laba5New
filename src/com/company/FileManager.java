package com.company;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {


    public void save(ArrayList<Country> countries, String fileName) throws IOException {
        FileWriter outStream = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(outStream);
        for (Country object : countries) {
            try {
                bw.write(object.getNameCountry());
                bw.write(System.lineSeparator());
                bw.write(object.getCapital());
                bw.write(System.lineSeparator());
                bw.write(object.getContinent());
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(object.getPopulation()));
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(object.getArea()));
                bw.write(System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        countries.clear();
        bw.close();
        outStream.close();
    }

    public void serialize(ArrayList<Country> countries, String fileName) throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(countries);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        countries.clear();
    }

    public void jacksonSerialize(Countries countries, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.writeValue(new File(fileName), countries);
    }

    public void load(ArrayList<Country> countries, String fileName) throws IOException {
        countries.clear();
        try {
            Scanner scan = new Scanner(new FileReader(fileName));
            String nameCountry;
            String capital;
            String continent;
            int population;
            int area;
            while (scan.hasNextLine()) {
                nameCountry = scan.nextLine();
                capital = scan.nextLine();
                continent = scan.nextLine();
                population = Integer.valueOf(scan.nextLine());
                area = Integer.valueOf(scan.nextLine());
                countries.add(new Country(nameCountry, capital, continent, population, area));
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList deserialize(ArrayList<Country> countries, String fileName) throws IOException {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            countries = (ArrayList<Country>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException с) {
            System.out.println("Not found!");
            с.printStackTrace();
        }
        return countries;
    }


    public ArrayList jacksonDeSerialize(ArrayList<Country> countries, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Countries newCountries = objectMapper.readValue(new File(fileName), Countries.class);
        return countries = newCountries.countries;
    }

}
