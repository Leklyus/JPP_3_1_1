package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    List<User> getUsers();

    User getUser(Long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

}
