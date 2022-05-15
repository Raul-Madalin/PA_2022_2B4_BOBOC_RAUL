package sources;

import java.sql.*;
import java.util.concurrent.Semaphore;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Database db = new Database();

        ContinentDAO continent = new ContinentDAO(db);
        try {
            continent.create("Europe");
            //out.println(continent.findById(1));
            //out.println(continent.findByName("Europe"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        CountryDAO country = new CountryDAO(db);
        try {
            country.create("Romania", 10, "Europe");
            //out.println(country.findById(1));
            //out.println(country.findByName("Romania"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            country.create("Poland", 11, "Europe");
            //out.println(country.findById(200));
            //out.println(country.findByName("Poland"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            country.create("Czech Republic", 12, "Europe");
            //out.println(country.findById(3));
            //out.println(country.findByName("Czech Republic"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //country.findByContinent("Europe");

        CityDAO city = new CityDAO(db);
        try {
            city.create("Bucharest", "Romania", true, 44.4268, 26.1025);
            //out.println(city.findByName("Bucharest"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            city.create("Iasi", "Romania", false, 47.1622, 27.5889);
            //out.println(city.findByName("Bucharest"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        out.println(city.distanceCalc("Bucharest", "Iasi"));
        db.closeConnection();
    }
}
