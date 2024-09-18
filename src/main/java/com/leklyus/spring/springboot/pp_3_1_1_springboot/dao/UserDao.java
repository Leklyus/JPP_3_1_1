package com.leklyus.spring.springboot.pp_3_1_1_springboot.dao;


import com.leklyus.spring.springboot.pp_3_1_1_springboot.models.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    List<User> getUsers();

    User getUser(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

}
