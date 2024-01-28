package models.interfaces;

import models.entities.User;

import java.util.List;

public interface Dao<T> {
    List<T> findAll();
    T findById(Integer id);
    Integer insert(T newObj);
    void Update(Integer id, T newObj);
    T deleteById(Integer id);

}
