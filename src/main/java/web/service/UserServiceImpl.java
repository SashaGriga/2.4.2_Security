package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    @Autowired
    public void DIUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;
    @Autowired
    public void DIRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public UserServiceImpl() {}

    private PasswordEncoder passwordEncoder;
    @Autowired
    public void DIPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.add(user);
    }

    @Transactional(readOnly=true)
    @Override
    public User getUserById(Long id) {
        return (User) userDao.getUserById(id);
    }

    @Override
    @Transactional(readOnly=true)
    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        return userDao.getListUsers();
    }

    @Transactional
    @Override
    public void update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.update(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Transactional(readOnly=true)
    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
