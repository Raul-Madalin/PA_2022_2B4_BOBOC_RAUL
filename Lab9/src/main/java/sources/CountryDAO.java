package sources;

import java.sql.*;

import static java.lang.System.*;

public class CountryDAO extends GenericDAO<CountryDAO> {

    private static Connection connection;

    public CountryDAO(Database db){
        connection = db.getConnection();
    }

    public void create(String name, int code, String continent) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT name FROM countries WHERE name='" + name + "'"
        );
        if(rs.next()){
            out.println("Country " + name + " already exists");
            return;
        }

        rs = stmt.executeQuery(
                "SELECT name FROM continents WHERE name='" + continent + "'"
        );
        if(!rs.next()){
            out.println("Continent doesn't exist");
            return;
        }

        PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO countries VALUES (?,?,?,?)"
        );

        rs = stmt.executeQuery(
                "SELECT MAX(id) FROM countries"
        );

        pstmt.setInt(1, rs.next() ? rs.getInt(1) + 1 : 1);
        pstmt.setString(2, name);
        pstmt.setInt(3, code);
        pstmt.setString(4, continent);
        pstmt.executeUpdate();
    }

    public CountryDAO findByName(String name) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT id FROM countries WHERE name='" + name + "'"
        );
        return this;
    }

    public CountryDAO findById(int id) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT name FROM countries WHERE id='" + id + "'"
        );
        return this;
    }

    public void findByContinent(String continent) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT name FROM countries WHERE continent='" + continent + "'"
        );
        //return rs.next() ? rs.getString(1) : null;
        while(rs.next()){
            out.println("Country " +  rs.getString(1) + " is in continent " + continent);
        }
    }

}
