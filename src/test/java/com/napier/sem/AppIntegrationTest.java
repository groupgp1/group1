package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testCities()
    {
        City city = app.getCity("Tilburg");
        assertEquals(city.getName(),"Tilburg");
        assertEquals(city.getCountry(), "NLD");
        assertEquals(city.getDistrict(), "Noord-Brabant");
    }

    @Test
    void testGetCitiesRegion()
    {
        ArrayList<City> cities = app.getCityRegion();
        for (City c: cities){
            String region = c.getRegion();
            assertEquals("Caribbean",region);
            break;
        }
    }
    @Test
    void testGetCitiesDistrict(){
        ArrayList<City> cities = app.getCityDistrict();
        for (City c: cities){
            String district = c.getDistrict();
            assertEquals("Gelderland",district);
            break;
        }
    }
    @Test
    void testGetCitiesLimit10(){
        ArrayList<City> cities = app.getCityLimit10();
        int i = 0;
        for (City city: cities){
            i += 1;
        }
        assertEquals(10,i);
    }
    @Test
    void testGetCitiesContinentLimit10(){
        ArrayList<City> cities = app.getCityContinentLimit10();
        int i = 0;
        for (City city: cities){
            i += 1;
        }
        assertEquals(10,i);
    }
    @Test
    void testGetCitiesRegionLimit10(){
        ArrayList<City> cities = app.getCityRegion();
        for (City c: cities){
            String region = c.getRegion();
            assertEquals("Caribbean",region);
            break;
        }
    }
    @Test
    void testGetCitiesCountryLimit10(){
        ArrayList<City> cities = app.getCityCountryLimit10();
        int i = 0;
        for (City city: cities){
            i += 1;
        }
        assertEquals(10,i);
    }
    @Test
    void testGetCitiesDistrictLimit10(){
        ArrayList<City> cities = app.getCityDistrictLimit10();
        for (City c: cities){
            String district = c.getDistrict();
            assertEquals("Gelderland",district);
            break;
        }
    }

}