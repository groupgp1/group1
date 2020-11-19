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
    public ArrayList<Country> getCountry()
    {
        try
        {
            System.out.println("All of the countries which are ordered by descending");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> count = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                Country cty = new Country();
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
    public ArrayList<Country> getCountryContinent()
    {
        try
        {
            System.out.println("All of the countries in a Asia Continent which are ordered by population descending ");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country WHERE Continent = 'Asia' order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> count1 = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                Country cty = new Country();
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
    public ArrayList<Country> getCountryRegion()
    {
        try
        {
            System.out.println("All of the countries in a Asia region which are ordered by population descending ");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country WHERE Region = 'North America' order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> count2 = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                Country cty = new Country();
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

    public ArrayList<Country> getCountryLimit10()
    {
        try
        {
            System.out.println("Top 10 countries which are ordered by descending");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country order by Population desc limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> count3 = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                Country cty = new Country();
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
    public ArrayList<Country> getCountryContinentLimit10()
    {
        try
        {
            System.out.println("Top 10  countries in a Asia Continent which are ordered by population descending ");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country WHERE Continent = 'Asia' order by Population desc limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> count4 = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                Country cty = new Country();
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
    public ArrayList<Country> getCountryRegionLimit10()
    {
        try
        {
            System.out.println("Top 10 countries in a Asia region which are ordered by population descending ");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Continent, Region, Population, Capital "
                            + "FROM country WHERE Region = 'North America' order by Population desc limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Country> count5 = new ArrayList<>();
            // Return new country if valid.
            // Check one is returned
            while (rset.next())
            {
                Country cty = new Country();
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
    public ArrayList<City> getCity()
    {
        try
        {
            System.out.println("All of the city which are ordered by descending");
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT Name, CountryCode, District, Population  from city order by Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count6 = new ArrayList<>();
            while (rset.next())
            {
                City cty = new City();
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
    
    public ArrayList<City> getCityContinent()
    {
        try
        {
            System.out.println("All of the cities in a Asia Continent which are ordered by population descending ");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population,country.Code, country.continent from city, country " +
                            "WHERE country.Continent = 'Asia' and CountryCode = country.Code order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count7 = new ArrayList<>();
            while (rset.next())
            {
                City cty = new City();
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

    public ArrayList<City> getCityRegion()
    {
        try
        {
            System.out.println("All the cities in a region organised by largest population to smallest ");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population,country.Code, country.Region from city, country " +
                            "WHERE country.Region = 'Caribbean' and CountryCode = country.Code order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count8 = new ArrayList<>();
            while (rset.next())
            {
                City cty = new City();
                cty.setName(rset.getString("Name"));
                cty.setCountry(rset.getString("CountryCode"));
                cty.setDistrict(rset.getString("District"));
                cty.setPopulation(rset.getString("population"));
                count8.add(cty);
            }
            return count8;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public ArrayList<City> getCityCountry()
    {
        try
        {
            System.out.println("All the cities in a country organised by largest population to smallest ");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population,country.Code from city, country " +
                            "WHERE CountryCode = country.Code order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count9 = new ArrayList<>();
            while (rset.next())
            {
                City cty = new City();
                cty.setName(rset.getString("Name"));
                cty.setCountry(rset.getString("CountryCode"));
                cty.setDistrict(rset.getString("District"));
                cty.setPopulation(rset.getString("population"));
                count9.add(cty);
            }
            return count9;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<City> getCityDistrict()
    {
        try
        {
            System.out.println("All the cities in a district organised by largest population to smallest ");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population,country.Code from city, country " +
                            "WHERE District = 'Gelderland' order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count10 = new ArrayList<>();
            while (rset.next())
            {
                City cty = new City();
                cty.setName(rset.getString("Name"));
                cty.setCountry(rset.getString("CountryCode"));
                cty.setDistrict(rset.getString("District"));
                cty.setPopulation(rset.getString("population"));
                count10.add(cty);
            }
            return count10;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<City> getCityLimit10()
    {
        try
        {
            System.out.println("All the cities in a top 10 populated cities in the world.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population from city limit 10 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count11 = new ArrayList<>();
            while (rset.next())
            {
                City cty = new City();
                cty.setName(rset.getString("Name"));
                cty.setCountry(rset.getString("CountryCode"));
                cty.setDistrict(rset.getString("District"));
                cty.setPopulation(rset.getString("population"));
                count11.add(cty);
            }
            return count11;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public void displayCountry(ArrayList<Country> countries)
    {
        System.out.println(String.format("%-10s %-15s %-20s %-15s %-15s %-15s", "Country No", "Name", "Continent", "Region", "Population", "Capital"));
        // Loop over all employees in the list
        for (Country c: countries)
        {
            String country_string =
                    String.format("%-10s %-15s %-20s %-15s %-15s %-15s",
                            c.ID, c.name, c.continent, c.region, c.population, c.capital);
            System.out.println(country_string);
        }
    }
    public void displayCity(ArrayList<City> cities)
    {
        System.out.println(String.format("%-10s %-10s %-10s %-10s", "Name", "Country", "District", "Population"));
        for(City c: cities)
        {
            String city_string = String.format("%-10s %-10s %-10s %-10s", c.getName(),c.getCountry(),c.getDistrict(),c.getPopulation());
            System.out.println(city_string);
        }
    }
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        // Get country

        //ArrayList<Country> count = a.getCountry();
        //a.displayCountry(count);
        //ArrayList<Country> count1 = a.getCountryContinent();
        //a.displayCountry(count1);
        //ArrayList<Country> count2 = a.getCountryRegion();
        //a.displayCountry(count2);
        //ArrayList<Country> count3 = a.getCountryLimit10();
        //a.displayCountry(count3);
        //ArrayList<Country> count4 = a.getCountryContinentLimit10();
        //a.displayCountry(count4);
        //ArrayList<Country> count5 = a.getCountryRegionLimit10();
        //a.displayCountry(count5);
        //ArrayList<City> count6 = a.getCity();
        //a.displayCity(count6);
        //ArrayList<City> count7 = a.getCityContinent();
        //a.displayCity(count7);
        //ArrayList<City> count8 = a.getCityRegion();
        //a.displayCity(count8);
        //ArrayList<City> count9 = a.getCityCountry();
        //a.displayCity(count9);
        //ArrayList<City> count10 = a.getCityDistrict();
        //a.displayCity(count10);
        ArrayList<City> count11 = a.getCityLimit10();
        a.displayCity(count11);
        // Display results
        // Disconnect from database
        a.disconnect();
    }
}