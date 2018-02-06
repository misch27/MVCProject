package app.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void executeUpdate(String update) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(update);
        stmt.close();
    }

    public <T> T executeQuery(String query,
                           ResultHandler<T> handler)
            throws SQLException {

        T value;
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet result = stmt.getResultSet();
        try {
            value = handler.handle(result);
            return value;
        }catch (SQLException sqlE){
            return null;
            //если значение не найдено - вывести null
        }finally {
            result.close();
            stmt.close();
        }


    }
}
