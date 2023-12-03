package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;


public class UserServiceImpl implements UserService {
    //private static final UserDao UDB = new UserDaoJDBCImpl();
    private static final UserDao UDB = new UserDaoHibernateImpl();

    public void createUsersTable() throws SQLException {
        UDB.createUsersTable();
    }

    public void dropUsersTable() {
        UDB.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UDB.saveUser(name, lastName, age);
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        UDB.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return UDB.getAllUsers();
    }

    public void cleanUsersTable() {
        UDB.cleanUsersTable();
    }
}
