package com.leklyus.spring.springboot.pp_3_1_1_springboot.dao;

import com.leklyus.spring.springboot.pp_3_1_1_springboot.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(Long id, User user) {
        User userUpdate = getUser(id);
        userUpdate.setAge(user.getAge());
        userUpdate.setName(user.getName());
        userUpdate.setSurname(user.getSurname());
        entityManager.merge(userUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUser(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
