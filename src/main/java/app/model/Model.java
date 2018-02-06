package app.model;import app.DAO.UsersDAO;import app.entities.User;import java.io.IOException;import java.sql.SQLException;//Одиночкаpublic class Model {    private static Model instance = new Model();    private UsersDAO usersDAO;    public static Model getInstance() {        return instance;    }    private Model(){        usersDAO = new UsersDAO();    }    public boolean addNewUser(User user) throws IOException {        try {            if (usersDAO.getUser(user) == null) {                usersDAO.insertUser(user);                return true;            } else {                return false;            }        }catch (SQLException sql){            sql.printStackTrace();            throw new IOException("Ошибка при создании пользователя");        }    }}