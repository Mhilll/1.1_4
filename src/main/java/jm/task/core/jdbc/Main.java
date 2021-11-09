package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {

        userService.createUsersTable();

        userService.saveUser("Кот",  "Котофеев", (byte)  5);
        userService.saveUser("Иван", "Иванов",   (byte) 35);
        userService.saveUser("Сидор","Сидоров",  (byte) 46);
        userService.saveUser("Пётр", "Петров",   (byte) 43);

        System.out.println(userService.getAllUsers().toString());

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
