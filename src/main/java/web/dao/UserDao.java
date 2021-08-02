package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getListUsers();
    void add(User user);
    void delete(Long id);
    void update(User user);
    User getUserById (Long id);
    User getUserByName(String name);

}
