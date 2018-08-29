package com.vol.notes.services;

import com.vol.notes.dao.RoleDao;
import com.vol.notes.dao.UserDao;
import com.vol.notes.model.Role;
import com.vol.notes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findByName("ROLE_USER"));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByName(String userName) {
        return userDao.findByName(userName);
    }
}
