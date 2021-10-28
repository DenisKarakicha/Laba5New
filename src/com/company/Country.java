package com.company;

import java.io.Serializable;

public class Country implements Serializable {
    String nameCountry;
    String capital;
    String continent;
    int population;
    int area;

    public Country(String nameCountry, String capital, String continent, int population, int area) {
        this.setNameCountry(nameCountry);
        this.setCapital(capital);
        this.setContinent(continent);
        this.setPopulation(population);
        this.setArea(area);
    }

    public Country() {
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = (population < 0) ? -1 : population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = (area < 0) ? -1 : area;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry.trim();
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital.trim();
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent.trim();
    }

    @Override
    public String toString() {
        return "Country{" +
                "nameCountry='" + nameCountry + '\'' +
                ", capital='" + capital + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}' + '\n';
    }
}
