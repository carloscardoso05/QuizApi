package models.daos.impl;

import db.DB;
import db.DbException;
import models.entities.User;
import models.interfaces.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBC implements Dao<User> {
    private final Connection connection;

    public UserDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                users.add(instantiateUser(resultSet));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return users;
    }

    @Override
    public User findById(Integer id) {
        User user;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("select * from users where id == ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            user = instantiateUser(resultSet);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }
        return user;
    }

    @Override
    public Integer insert(User newObj) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Integer id = null;

        try {
            statement = connection.prepareStatement("insert into users (name)" +
                    "values (?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, newObj.getName());
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    id = resultSet.getInt("id");
                    newObj.setId(id);
                }
            } else {
                throw new DbException("Erro inesperado, nenhuma linha foi afetada");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }
        return id;
    }

    @Override
    public void Update(Integer id, User newObj) {

    }

    @Override
    public User deleteById(Integer id) {
        return null;
    }

    private User instantiateUser(ResultSet resultSet) throws SQLException {
        int id;
        String name;
        id = resultSet.getInt("id");
        name = resultSet.getString("name");
        return new User(id, name);
    }
}
