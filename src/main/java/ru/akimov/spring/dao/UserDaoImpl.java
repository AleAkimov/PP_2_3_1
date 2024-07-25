package ru.akimov.spring.dao;

import org.springframework.stereotype.Repository;
import ru.akimov.spring.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(int id) {
        User user = findById(id);
        if (user == null) {
            logger.warning("Trying to delete not existent user. User is null");
            return;
        }
        em.remove(findById(id));
    }

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }
}
//@Repository
//public class UserDaoImpl implements UserDao {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
//    public List<User> getAllUsers() {
//        return em.createQuery("SELECT u from User u", User.class).getResultList();
//    }
//
//    @Override
//    public User getByIdUser(int id) {
//        return em.find(User.class, id);
//    }
//
//    @Override
//    public void save(User user) {
//        em.persist(user);
//    }
//
//    @Override
//    public void update(User user) {
//        em.merge(em.contains(user) ? user : em.merge(user));
//    }
//
//    @Override
//    public void delete(User user) {
//        em.remove(em.contains(user) ? user : em.merge(user));
//    }
//}