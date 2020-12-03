package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    private Connection con = null;
    // Connect Function
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
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
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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
                cty.population = rset.getString("Population");
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
                cty.population = rset.getString("Population");
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
                cty.population = rset.getString("Population");
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
                cty.population = rset.getString("Population");
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
                cty.population = rset.getString("Population");
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
                cty.population = rset.getString("Population");
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
                cty.setPopulation(rset.getInt("population"));
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
                cty.setPopulation(rset.getInt("population"));
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
                cty.setPopulation(rset.getInt("population"));
                cty.setRegion(rset.getString("country.Region"));
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
                cty.setPopulation(rset.getInt("population"));
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
                cty.setPopulation(rset.getInt("population"));
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
                cty.setPopulation(rset.getInt("population"));
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
    public ArrayList<City> getCityContinentLimit10()
    {
        try
        {
            System.out.println("The top 10 populated cities in a continent");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population,country.Code, country.continent from city, country WHERE country.Continent = 'Asia' and CountryCode = country.Code limit 10 ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count12 = new ArrayList<>();
            while (rset.next())
            {
                City cty = new City();
                cty.setName(rset.getString("Name"));
                cty.setCountry(rset.getString("CountryCode"));
                cty.setDistrict(rset.getString("District"));
                cty.setPopulation(rset.getInt("population"));
                count12.add(cty);
            }
            return count12;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<City> getCityRegionLimit10()
    {
        try
        {
            System.out.println("top 10 populated cities in a Region");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population,country.Code, country.Region from city, country " +
                            "WHERE country.Region = 'Caribbean' and CountryCode = country.Code limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count13 = new ArrayList<>();
            while (rset.next())
            {
                City cty = new City();
                cty.setName(rset.getString("Name"));
                cty.setCountry(rset.getString("CountryCode"));
                cty.setDistrict(rset.getString("District"));
                cty.setPopulation(rset.getInt("population"));
                cty.setRegion(rset.getString("country.Region"));
                count13.add(cty);
            }
            return count13;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<City> getCityCountryLimit10()
    {
        try
        {
            System.out.println("top 10 populated cities in a country");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population,country.Code from city, country " +
                            "WHERE CountryCode = country.Code limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count14 = new ArrayList<>();
            while (rset.next())
            {
                City cty = new City();
                cty.setName(rset.getString("Name"));
                cty.setCountry(rset.getString("CountryCode"));
                cty.setDistrict(rset.getString("District"));
                cty.setPopulation(rset.getInt("population"));
                count14.add(cty);
            }
            return count14;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<City> getCityDistrictLimit10()
    {
        try
        {
            System.out.println("Top 10 populated cities in a district");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, city.District, city.Population,country.Code from city, country " +
                            "WHERE District = 'Gelderland' limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count15 = new ArrayList<>();
            while (rset.next())
            {
                City cty = new City();
                cty.setName(rset.getString("Name"));
                cty.setCountry(rset.getString("CountryCode"));
                cty.setDistrict(rset.getString("District"));
                cty.setPopulation(rset.getInt("population"));
                count15.add(cty);
            }
            return count15;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<City> getCapitalCities()
    {
        try
        {
            System.out.println("All the capital cities in the world organised by largest population to smallest.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID,country.Capital,city.Name,country.Code,city.CountryCode,country.Name,city.Population from city, country Where" +
                            " country.Capital = city.ID and city.CountryCode = country.Code order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count16 = new ArrayList<>();
            while (rset.next())
            {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountry(rset.getString("country.Name"));
                c.setPopulation(rset.getInt("city.Population"));
                count16.add(c);
            }
            return count16;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public ArrayList<City> getCapitalCitiesContinent()
    {
        try
        {
            System.out.println("All the capital cities in a continent organised by largest population to smallest.");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID,country.Capital,city.Name,country.Code,city.CountryCode,country.Name,country.Continent,city.Population from city, country Where" +
                            " country.Capital = city.ID and city.CountryCode = country.Code and country.Continent = 'Asia' order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count17 = new ArrayList<>();
            while (rset.next())
            {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountry(rset.getString("country.Name"));
                c.setPopulation(rset.getInt("city.Population"));
                count17.add(c);
            }
            return count17;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public ArrayList<City> getCapitalCitiesRegion()
    {
        try
        {
            System.out.println("All the capital cities in a region organised by largest to smallest");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID,country.Capital,city.Name,country.Code,city.CountryCode,country.Name,country.Region,city.Population from city, country Where" +
                            " country.Capital = city.ID and city.CountryCode = country.Code and country.Region = 'Caribbean' order by Population desc";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count18 = new ArrayList<>();
            while (rset.next())
            {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountry(rset.getString("country.Name"));
                c.setPopulation(rset.getInt("city.Population"));
                count18.add(c);
            }
            return count18;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public ArrayList<City> getCapitalCitiesLimit10()
    {
        try
        {
            System.out.println("The top 10 populated capital cities in the world");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID,country.Capital,city.Name,country.Code,city.CountryCode,country.Name,country.Region,city.Population from city, country Where" +
                            " country.Capital = city.ID and city.CountryCode = country.Code limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count19 = new ArrayList<>();
            while (rset.next())
            {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountry(rset.getString("country.Name"));
                c.setPopulation(rset.getInt("city.Population"));
                count19.add(c);
            }
            return count19;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public ArrayList<City> getCapitalCitiesContinentLimit10()
    {
        try
        {
            System.out.println("The top 10 populated capital cities in a continent");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID,country.Capital,city.Name,country.Code,city.CountryCode,country.Name,country.Continent,city.Population from city, country Where" +
                            " country.Capital = city.ID and city.CountryCode = country.Code and country.Continent = 'Asia' limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count20 = new ArrayList<>();
            while (rset.next())
            {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountry(rset.getString("country.Name"));
                c.setPopulation(rset.getInt("city.Population"));
                count20.add(c);
            }
            return count20;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public ArrayList<City> getCapitalCitiesRegionLimit10()
    {
        try
        {
            System.out.println("The top 10 populated capital cities in a region");
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID,country.Capital,city.Name,country.Code,city.CountryCode,country.Name,country.Region,city.Population from city, country Where" +
                            " country.Capital = city.ID and city.CountryCode = country.Code and country.Region = 'Caribbean' limit 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<City> count21 = new ArrayList<>();
            while (rset.next())
            {
                City c = new City();
                c.setName(rset.getString("city.Name"));
                c.setCountry(rset.getString("country.Name"));
                c.setPopulation(rset.getInt("city.Population"));
                count21.add(c);
            }
            return count21;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<City> getPopulationContinent()
    {
        try
        {
            System.out.println("The population of people, people living in cities, and people not living in cities in each continent.");
            // Create an SQL statement
            ArrayList<City> count23 = new ArrayList<>();
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(city.Population) as cityPopulation, SUM(DISTINCT country.Population) as countryPopulation, country.Continent FROM city, country WHERE country.Code IN (SELECT Code FROM country) GROUP BY country.Continent" ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                City cty = new City();
                cty.setName(rset.getString("country.Continent"));
                cty.setName(rset.getString("country.Continent"));
                Long pop = cty.setCityPopulation(rset.getLong("cityPopulation"));
                long tPop = cty.setTotalPopulation(rset.getLong("countryPopulation"));
                long notLiving = tPop - pop;
                cty.setNotLiving(notLiving);
                count23.add(cty);
            }
            return count23;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public ArrayList<City> getPopulationRegion()
    {
        try
        {
            System.out.println("The population of people, people living in cities, and people not living in cities in each region");
            // Create an SQL statement
            ArrayList<City> count21 = new ArrayList<>();
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT SUM(city.Population) as cityPopulation, SUM(DISTINCT country.Population) as countryPopulation, country.Region FROM city, country WHERE country.Code IN (SELECT Code FROM country) GROUP BY country.Region" ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                City cty = new City();
                cty.setName(rset.getString("country.Region"));
                Long pop = cty.setCityPopulation(rset.getLong("cityPopulation"));
                long tPop = cty.setTotalPopulation(rset.getLong("countryPopulation"));
                long notLiving = tPop - pop;
                cty.setNotLiving(notLiving);
                count21.add(cty);
            }
            return count21;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public ArrayList<City> getPopulationCountry()
    {
        try
        {
            System.out.println("The population of people, people living in cities, and people not living in cities in each country");
            // Create an SQL statement
            ArrayList<City> count21 = new ArrayList<>();
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT SUM(city.Population) as cityPopulation, SUM(DISTINCT country.Population) as countryPopulation, country.Name FROM city, country WHERE country.Code= city.CountryCode GROUP BY country.Name" ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                City cty = new City();
                cty.setName(rset.getString("country.Name"));
                long pop = cty.setCityPopulation(rset.getLong("cityPopulation"));
                long tPop = cty.setTotalPopulation(rset.getLong("countryPopulation"));
                long notLiving = tPop - pop;
                cty.setNotLiving(notLiving);
                count21.add(cty);
            }
            return count21;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public ArrayList<Country> getWorldPopulation()
    {
        try
        {
            // Create an SQL statement
            ArrayList<Country> count22 = new ArrayList<>();
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT SUM(country.Population) as countryPopulation from country" ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                Country c = new Country();
                c.setPopulation(rset.getString("countryPopulation"));
                count22.add(c);
            }
            return count22;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public void displayWorldPopulation(ArrayList<Country> country)
    {
        if (country == null){
            System.out.println("No Population");
            return;
        }
        for(Country c: country)
        {
            if (c == null)
                continue;

            System.out.println("The Population of the World is "+c.getPopulation());
        }
    }

    public ArrayList<Country> getContinentPopulation()
    {
        try
        {
            // Create an SQL statement
            ArrayList<Country> count26 = new ArrayList<>();
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT SUM(country.Population) as countryPopulation FROM country WHERE Continent = 'Asia'" ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                Country c = new Country();
                c.setPopulation(rset.getString("countryPopulation"));
                count26.add(c);
            }
            return count26;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public ArrayList<Country> getRegionPopulation()
    {
        try
        {
            // Create an SQL statement
            ArrayList<Country> count27 = new ArrayList<>();
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT SUM(Population) FROM country WHERE Region = 'Middle East'" ;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next())
            {
                Country c = new Country();
                c.setPopulation(rset.getString("SUM(Population)"));
                count27.add(c);
            }
            return count27;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }

    public void displayRegion(ArrayList<Country> country)
    {
        if (country == null){
            System.out.println("No Population");
            return;
        }
        for(Country c: country)
        {
            if (c == null)
                continue;

            System.out.println("The Population of a Region is "+c.getPopulation());
        }
    }

    public void displayContinent(ArrayList<Country> country)
    {
        if (country == null){
            System.out.println("No Population");
            return;
        }
        for(Country c: country)
        {
            if (c == null)
                continue;

            System.out.println("The Population of the Continent is "+c.getPopulation());
        }
    }
    public void displayPopulation(ArrayList<City> cities)
    {
        if (cities == null){
            System.out.println("No Cities");
            return;
        }
        System.out.println(String.format("%-30s %-30s %-30s %-30s", "Name", "total population", "living in cities", "not living in cities"));
        for(City c: cities)
        {
            if (c == null)
                continue;
            long tPop = c.getTotalPopulation();
            double living = c.getCityPopulation();
            double livingPercentage = living / tPop;
            livingPercentage = livingPercentage * 100;
            double notLivingPercentage = 100 - livingPercentage;
            String city_string = String.format("%-30s %-30s %-30s %-30s", c.getName(),tPop,living + "("+ livingPercentage +")",c.getNotLiving() + "(" + notLivingPercentage + ")");
            System.out.println(city_string);
        }
    }
    public City getCity(String name)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, CountryCode, District, Population "
                            + "FROM city "
                            + "WHERE Name = 'Tilburg'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                City c = new City();
                c.setName(rset.getString("Name"));
                c.setCountry(rset.getString("CountryCode"));
                c.setDistrict(rset.getString("District"));
                c.setPopulation(rset.getInt("Population"));
                return c;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }
    public void displayCountry(ArrayList<Country> countries)
    {
        if (countries == null){
            System.out.println("No countries");
            return;
        }
        System.out.println(String.format("%-10s %-15s %-20s %-15s %-15s %-15s", "Country No", "Name", "Continent", "Region", "Population", "Capital"));
        // Loop over all employees in the list
        for (Country c: countries)
        {
            if (c == null)
                continue;
            String country_string =
                    String.format("%-10s %-15s %-20s %-15s %-15s %-15s",
                            c.ID, c.name, c.continent, c.region, c.population, c.capital);
            System.out.println(country_string);
        }
    }
    public void displayCity(ArrayList<City> cities)
    {
        if (cities == null){
            System.out.println("No Cities");
            return;
        }
        System.out.println(String.format("%-10s %-10s %-10s %-10s", "Name", "Country", "District", "Population"));
        for(City c: cities)
        {
            if (c == null)
                continue;
            String city_string = String.format("%-10s %-10s %-10s %-10s", c.getName(),c.getCountry(),c.getDistrict(),c.getPopulation());
            System.out.println(city_string);
        }
    }

    public void displayCapital(ArrayList<City> cities)
    {
        if (cities == null){
            System.out.println("No Cities");
            return;
        }
        System.out.println(String.format("%-20s %-20s %-20s", "Name", "Country", "Population"));
        for(City c: cities)
        {
            if (c == null)
                continue;
            String city_string = String.format("%-20s %-20s %-20s", c.getName(),c.getCountry(),c.getPopulation());
            System.out.println(city_string);
        }
    }
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:3306");
        }
        else
        {
            a.connect(args[0]);
        }

        // Get country

        ArrayList<Country> count = a.getCountry();
        a.displayCountry(count);
        ArrayList<Country> count1 = a.getCountryContinent();
        a.displayCountry(count1);
        ArrayList<Country> count2 = a.getCountryRegion();
        a.displayCountry(count2);
        ArrayList<Country> count3 = a.getCountryLimit10();
        a.displayCountry(count3);
        ArrayList<Country> count4 = a.getCountryContinentLimit10();
        a.displayCountry(count4);
        ArrayList<Country> count5 = a.getCountryRegionLimit10();
        a.displayCountry(count5);
        ArrayList<City> count6 = a.getCity();
        a.displayCity(count6);
        ArrayList<City> count7 = a.getCityContinent();
        a.displayCity(count7);
        ArrayList<City> count8 = a.getCityRegion();
        a.displayCity(count8);
        ArrayList<City> count9 = a.getCityCountry();
        a.displayCity(count9);
        ArrayList<City> count10 = a.getCityDistrict();
        a.displayCity(count10);
        ArrayList<City> count11 = a.getCityLimit10();
        a.displayCity(count11);
        ArrayList<City> count12 = a.getCityContinentLimit10();
        a.displayCity(count12);
        ArrayList<City> count13 = a.getCityRegionLimit10();
        a.displayCity(count13);
        ArrayList<City> count14 = a.getCityCountryLimit10();
        a.displayCity(count14);
        ArrayList<City> count15 = a.getCityDistrictLimit10();
        a.displayCity(count15);
        ArrayList<City> count16 = a.getCapitalCities();
        a.displayCapital(count16);
        ArrayList<City> count17 = a.getCapitalCitiesContinent();
        a.displayCapital(count17);
        ArrayList<City> count18 = a.getCapitalCitiesRegion();
        a.displayCapital(count18);
        ArrayList<City> count19 = a.getCapitalCitiesLimit10();
        a.displayCapital(count19);
        ArrayList<City> count20 = a.getCapitalCitiesContinentLimit10();
        a.displayCapital(count20);
        ArrayList<City> count21 = a.getCapitalCitiesRegionLimit10();
        a.displayCapital(count21);
        ArrayList<City> count22 = a.getPopulationRegion();
        a.displayPopulation(count22);
        ArrayList<City> count23 = a.getPopulationContinent();
        a.displayPopulation(count23);
        ArrayList<City> count24 = a.getPopulationCountry();
        a.displayPopulation(count24);
        ArrayList<Country> count25 = a.getWorldPopulation();
        a.displayWorldPopulation(count25);
        ArrayList<Country> count26 = a.getContinentPopulation();
        a.displayContinent(count26);
        ArrayList<Country> count27 = a.getRegionPopulation();
        a.displayRegion(count27);
        // Display results
        // Disconnect from database
        a.disconnect();
    }
}