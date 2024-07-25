package ru.akimov.spring.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akimov.spring.dao.UserDao;
import ru.akimov.spring.model.User;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }
}
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final UserDao userDao;
//
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public List<User> getAllUsers() {
//        return userDao.getAllUsers();
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public User getByIdUser(int id) {
//        return userDao.getByIdUser(id);
//    }
//
//    @Transactional
//    @Override
//    public void delete(User user) {
//        userDao.delete(user);
//    }
//
//    @Transactional
//    @Override
//    public void save(User user) {
//        userDao.save(user);
//    }
//
//    @Transactional
//    @Override
//    public void update(User user) {
//        userDao.update(user);
//    }
//}