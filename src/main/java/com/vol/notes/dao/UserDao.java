package com.vol.notes.dao;

import com.vol.notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByName(String userName);
}
