package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> getListUsers();
    void add(User user);
    void delete(Long id);
    void update(User user);
    User getUserById (Long id);
    Set<Role> getAllRoles();
    User getUserByName(String name);
}
