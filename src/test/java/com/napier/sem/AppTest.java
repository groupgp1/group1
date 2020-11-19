package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printCitiesNull()
    {
        app.displayCity(null);
    }

    @Test
    void printCountriesNull(){
        app.displayCountry(null);
    }
    @Test
    void displayCitiesTestEmpty()
    {
        ArrayList<City> Cities = new ArrayList<City>();
        app.displayCity(Cities);
    }
    @Test
    void displayCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountry(countries);
    }
    @Test
    void displayCityTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<City>();
        city.add(null);
        app.displayCity(city);
    }
    @Test
    void displayCountryTestContainsNull()
    {
        ArrayList<Country> country = new ArrayList<Country>();
        country.add(null);
        app.displayCountry(country);
    }
}