package com.napier.sem;

public class City {
    private String name;
    private String country;
    private String District;
    private int Population;
    private String Region;
    private String Continent;
    private int totalPopulation;
    private int notLiving;

    public int getTotalPopulation() {
        return totalPopulation;
    }

    public int setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
        return totalPopulation;
    }

    public int getNotLiving() {
        return notLiving;
    }

    public void setNotLiving(int notLiving) {
        this.notLiving = notLiving;
    }


    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getPopulation() {
        return Population;
    }

    public int setPopulation(int population) {
        Population = population;
        return population;
    }
}
