package web.service;

import web.models.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    public List<User> getUsers();

    public User getUser(Long id);

    public void updateUser(Long id, User user);

    public void deleteUser(Long id);

}
