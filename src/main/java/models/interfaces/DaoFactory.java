package models.interfaces;

import models.daos.impl.UserDaoJDBC;
import models.entities.User;

import java.sql.Connection;

public class DaoFactory {
    public static Dao<User> createUserDao(Connection connection) {
        return new UserDaoJDBC(connection);
    }
}
