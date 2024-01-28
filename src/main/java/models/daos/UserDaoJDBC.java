package models.daos;

import models.entities.User;
import models.interfaces.Dao;

import java.util.List;

public class UserDao implements Dao<User> {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public Integer insert(User newObj) {
        return null;
    }

    @Override
    public void Update(Integer id, User newObj) {

    }

    @Override
    public User deleteById(Integer id) {
        return null;
    }
}
