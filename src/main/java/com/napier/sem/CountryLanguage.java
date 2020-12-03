package com.napier.sem;

public class CountryLanguage {
    private String countryCode;
    private String 	language;
    private String 	isOfficial;
    private int percentage;
    private long population;

    public long getWorldPopulation() {
        return worldPopulation;
    }

    public void setWorldPopulation(long worldPopulation) {
        this.worldPopulation = worldPopulation;
    }

    private long worldPopulation;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
