package ru.akimov.spring.dao;

import ru.akimov.spring.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void save(User user);

    void update(User user);

    void delete(int id);

    User findById(int id);
}
//public interface UserDao {
//
//    List<User> getAllUsers();
//
//    User getByIdUser(int id);
//
//    void save(User user);
//
//    void update(User user);
//
//    void delete(User user);
//}