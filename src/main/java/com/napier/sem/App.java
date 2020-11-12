package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
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

    /**
     * Disconnect from the MySQL database.
     */
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
    public ArrayList<country> getcountry()
    {
        try
        {
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
                displaycountry(cty);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get world details");
        }
        return null;
    }
    public void displaycountry(country cty)
    {

        if (cty != null)
        {
            System.out.println(
                    cty.ID + "  "
                            + cty.name + " "
                            + cty.continent + "  "
                            + cty.region + "  "
                            + cty.population + "  "
                            + cty.capital + "  ");
        }
    }
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        // Get country
        System.out.println("All of the countries which are ordered by descending");
        System.out.println(
                "Code" + "\t" + "Name" + "\t" + "Continent" + "\t" + "Region" + "\t" + "Population" + "\t" + "capital"
        );
        ArrayList<country> count = a.getcountry();
        // Display results
        // Disconnect from database
        a.disconnect();
    }
}