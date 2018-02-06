package app.DAO;

import app.entities.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class UsersDAO {
    private Executor executor;
    private final Connection connection;
    public UsersDAO() {
        connection = getMysqlConnection();
        this.executor = new Executor(connection);
        try {
         createTable();
        }catch (SQLException sql){
            System.out.println("Таблица создана ранее");
        }

    }

    public User getUser(User user) throws SQLException {
            return executor.executeQuery("select * from users where user_name='"
                    + user.getName() +"'", result -> {
                result.next();
                return new User(result.getString(2), result.getString(3));
            });
        }



    public void insertUser(User newUser) throws SQLException {
        executor.executeUpdate("insert into users (user_name, password) values ('"
                + newUser.getName() + "', '"
                +newUser.getPassword()+"')");
    }

    public void createTable() throws SQLException {
        executor.executeUpdate("create table if not exists users (" +
                "id bigint auto_increment, " +
                "user_name varchar(256), " +
                "password varchar(256), " +
                "primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.executeUpdate("drop table users");
    }
    private static Connection getMysqlConnection() {
        try {

            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://").
                    append("localhost:").
                    append("3306/").
                    append("servermvc?").
                    append("user=root&").
                    append("password=root");

            System.out.println("URL: " + url + "\n");

            return DriverManager.getConnection(url.toString());
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException  e) {
            e.printStackTrace();
        }
        return null;
    }
}
