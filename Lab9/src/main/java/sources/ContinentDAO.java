package sources;

import java.sql.*;

import static java.lang.System.*;

public class ContinentDAO extends GenericDAO<ContinentDAO> {

    private static Connection connection;

    public ContinentDAO(Database db){
        connection = db.getConnection();
    }

    public void create(String name) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT name FROM continents WHERE name='" + name + "'"
        );
        if(rs.next()){
            out.println("Continent " + name + " already exists");
            return;
        }

        PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO continents VALUES (?,?)"
        );

        rs = stmt.executeQuery(
            "SELECT MAX(id) FROM continents"
        );

        pstmt.setInt(1, rs.next() ? rs.getInt(1) + 1 : 1);
        pstmt.setString(2, name);
        pstmt.executeUpdate();
    }

    public ContinentDAO findByName(String name) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT id FROM continents WHERE name='" + name + "'"
        );
        return this;
    }

    public ContinentDAO findById(int id) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT name FROM continents WHERE id='" + id + "'"
        );
        return this;
    }

}
