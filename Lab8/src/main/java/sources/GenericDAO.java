package sources;

import java.sql.SQLException;
import java.util.List;

public abstract class GenericDAO<T> {

    public abstract T findById(int id) throws SQLException;
    public abstract T findByName(String name) throws SQLException;
}
