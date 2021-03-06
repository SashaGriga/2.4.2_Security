package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDAO;
    @Autowired
    public void DIUserDao(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    public UserDetailsServiceImpl() {}

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userDAO.getUserByName(name);
    }
}