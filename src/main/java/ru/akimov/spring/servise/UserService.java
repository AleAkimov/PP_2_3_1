package ru.akimov.spring.servise;
import ru.akimov.spring.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void update(User user);

    void delete(int id);

    User findById(int id);

    List<User> getAllUser();
}
//public interface UserService {
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
//
//}