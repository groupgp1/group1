package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    private Connection con = null;
    // Connect Function
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    // Disconnect Function
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
    public ArrayList<country> GetCountry()
    {
        try
        {
            System.out.println("All of the countries which are ordered by descending");
            System.out.println(
                    "Code" + "\t" + "Name" + "\t" + "Continent" + "\t" + "Region" + "\t" + "Population" + "\t" + "capital"
            );
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<country> count = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                country cty = new country();
                cty.name = rset.getString("Name");
                cty.continent= rset.getString("Continent");
                cty.region = rset.getString("Region");
                cty.population = rset.getInt("Population");
                cty.capital = rset.getInt("Capital");
                count.add(cty);
            }
            return count;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<country> GetCountryContinent()
    {
        try
        {
            System.out.println("All of the countries in a Asia Continent which are ordered by population descending ");
            System.out.println(
                    "Code" + "\t" + "Name" + "\t" + "Continent" + "\t" + "Region" + "\t" + "Population" + "\t" + "capital"
            );
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country WHERE Continent = 'Asia' order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<country> count1 = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                country cty = new country();
                cty.name = rset.getString("Name");
                cty.continent= rset.getString("Continent");
                cty.region = rset.getString("Region");
                cty.population = rset.getInt("Population");
                cty.capital = rset.getInt("Capital");
                count1.add(cty);
            }
            return count1;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<country> GetCountryRegion()
    {
        try
        {
            System.out.println("All of the countries in a Asia region which are ordered by population descending ");
            System.out.println(
                    "Code" + "\t" + "Name" + "\t" + "Continent" + "\t" + "Region" + "\t" + "Population" + "\t" + "capital"
            );
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country WHERE Region = 'North America' order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<country> count2 = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                country cty = new country();
                cty.name = rset.getString("Name");
                cty.continent= rset.getString("Continent");
                cty.region = rset.getString("Region");
                cty.population = rset.getInt("Population");
                cty.capital = rset.getInt("Capital");
                count2.add(cty);
            }
            return count2;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public ArrayList<country> GetCountryLimit10()
    {
        try
        {
            System.out.println("Top 10 countries which are ordered by descending");
            System.out.println(
                    "Code" + "\t" + "Name" + "\t" + "Continent" + "\t" + "Region" + "\t" + "Population" + "\t" + "capital"
            );
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country order by Population desc limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<country> count3 = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                country cty = new country();
                cty.name = rset.getString("Name");
                cty.continent= rset.getString("Continent");
                cty.region = rset.getString("Region");
                cty.population = rset.getInt("Population");
                cty.capital = rset.getInt("Capital");
                count3.add(cty);
            }
            return count3;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<country> GetCountryContinentLimit10()
    {
        try
        {
            System.out.println("Top 10  countries in a Asia Continent which are ordered by population descending ");
            System.out.println(
                    "Code" + "\t" + "Name" + "\t" + "Continent" + "\t" + "Region" + "\t" + "Population" + "\t" + "capital"
            );
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country WHERE Continent = 'Asia' order by Population desc limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<country> count4 = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                country cty = new country();
                cty.name = rset.getString("Name");
                cty.continent= rset.getString("Continent");
                cty.region = rset.getString("Region");
                cty.population = rset.getInt("Population");
                cty.capital = rset.getInt("Capital");
                count4.add(cty);
            }
            return count4;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<country> GetCountryRegionLimit10()
    {
        try
        {
            System.out.println("Top 10 countries in a Asia region which are ordered by population descending ");
            System.out.println(
                    "Code" + "\t" + "Name" + "\t" + "Continent" + "\t" + "Region" + "\t" + "Population" + "\t" + "capital"
            );
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country WHERE Region = 'North America' order by Population desc limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<country> count5 = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                country cty = new country();
                cty.name = rset.getString("Name");
                cty.continent= rset.getString("Continent");
                cty.region = rset.getString("Region");
                cty.population = rset.getInt("Population");
                cty.capital = rset.getInt("Capital");
                count5.add(cty);
            }
            return count5;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    // execute all of the city ordering with population
    public ArrayList<city> GetCity()
    {
        try
        {
            System.out.println("All of the city which are ordered by descending");
            System.out.println(
                    "Name" + "\t" + "Country" + "\t" + "Distinct" + "\t" + "Population"
            );
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, CountryCode, District, Population  from city order by Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<city> count6 = new ArrayList<>();
            while (rset.next())
            {
                city cty = new city();
                cty.setName(rset.getString("Name"));
                cty.setCountry(rset.getString("CountryCode"));
                cty.setDistrict(rset.getString("District"));
                cty.setPopulation(rset.getString("population"));
                count6.add(cty);
            }
            return count6;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    
    public ArrayList<city> GetCityContinent()
    {
        try
        {
            System.out.println("All of the cities in a Asia Continent which are ordered by population descending ");
            System.out.println(
                    "Name" + "\t" + "Country" + "\t" + "Distinct" + "\t" + "Population"
            );
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population,country.Code, country.continent from city, country " +
                            "WHERE country.Continent = 'Asia' and CountryCode = country.Code order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<city> count7 = new ArrayList<>();
            while (rset.next())
            {
                city cty = new city();
                cty.setName(rset.getString("Name"));
                cty.setCountry(rset.getString("CountryCode"));
                cty.setDistrict(rset.getString("District"));
                cty.setPopulation(rset.getString("population"));
                count7.add(cty);
            }
            return count7;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public void DisplayCountry(ArrayList<country> countries)
    {
        for(country c: countries){
            System.out.println(
                    c.ID + "  "
                            + c.name + " "
                            + c.continent + "  "
                            + c.region + "  "
                            + c.population + "  "
                            + c.capital + "  ");
        }
    }
    public void DisplayCity(ArrayList<city> cities)
    {
        for(city c: cities){
            System.out.println(
                    c.getName()+ "  "
                            + c.getCountry() + " "
                            + c.getDistrict() + "  "
                            + c.getPopulation()+ "  ");
    }
    }
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        // Get country

        // ArrayList<country> count = a.GetCountry();
        // ArrayList<country> count1 = a.GetCountryContinent();
        // ArrayList<country> count2 = a.GetCountryRegion();
        ArrayList<country> count3 = a.GetCountryLimit10();
        // ArrayList<country> count4 = a.GetCountryContinentLimit10();
        // ArrayList<country> count5 = a.GetCountryRegionLimit10();
        // ArrayList<city> count6 = a.GetCity();
        //ArrayList<city> count7 = a.GetCityContinent();
        // Display results
        a.DisplayCountry(count3);
        //a.DisplayCity(count7);
        // Disconnect from database
        a.disconnect();
    }
}