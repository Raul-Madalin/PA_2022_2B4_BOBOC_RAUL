package sources;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class CityDAO extends GenericDAO<CityDAO> {
    private static Connection connection;

    public CityDAO(Database db){
        connection = db.getConnection();
    }

    public void create(String name, String country, boolean isCapital, double latitude, double longitude) throws SQLException {

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT name FROM cities WHERE name='" + name + "'"
        );
        if(rs.next()){
            out.println("City " + name + " already exists");
            return;
        }
        rs.close();

        rs = stmt.executeQuery(
                "SELECT id FROM countries WHERE name='" + country + "'"
        );
        if(!rs.next()){
            out.println("Country doesn't exist");
            return;
        }
        int countryId = rs.getInt(1);

        PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO cities SELECT COUNT(*)+1,?,?,?,?,? FROM cities"
        );

        pstmt.setString(1, name);
        pstmt.setBoolean(2, isCapital);
        pstmt.setDouble(3, latitude);
        pstmt.setDouble(4, longitude);
        pstmt.setInt(5, countryId);
        pstmt.executeUpdate();
    }

    public CityDAO findByName(String name) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT id FROM cities WHERE name='" + name + "'"
        );
        return this;
    }

    public CityDAO findById(int id) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT name FROM cities WHERE id='" + id + "'"
        );
        return this;
    }

    public Double distanceCalc(String city1, String city2) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT latitude, longitude FROM cities WHERE name='" + city1 + "'"
        );
        if(!rs.next()){
            out.println("First city does not exist");
            return -1d;
        }
        double lat1 = Math.toRadians(rs.getDouble(1));
        double lon1 = Math.toRadians(rs.getDouble(2));
        rs.close();

        rs = stmt.executeQuery(
                "SELECT latitude, longitude FROM cities WHERE name='" + city2 + "'"
        );
        if(!rs.next()){
            out.println("Second city does not exist");
            return -1d;
        }
        double lat2 = Math.toRadians(rs.getDouble(1));
        double lon2 = Math.toRadians(rs.getDouble(2));
        rs.close();

        stmt.close();

        double dlong = lon2 - lon1;
        double dlat = lat2 - lat1;
        double ans = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlong / 2),2);

        ans = 2 * Math.asin(Math.sqrt(ans));
        double r = 6371;

        return(ans * r);
    }
}
