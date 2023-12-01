package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Джон", "Леннон", (byte) 40);
        userService.saveUser("Ринго", "Старр", (byte) 83);
        userService.saveUser("Пол", "Маккартни", (byte) 81);
        userService.saveUser("Джордж", "Харрисон", (byte) 58);

        //userService.removeUserById(1);
        List<User> users = userService.getAllUsers();

        for(User user : users) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
