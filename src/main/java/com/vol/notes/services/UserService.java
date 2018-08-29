package com.vol.notes.services;

import com.vol.notes.model.User;

public interface UserService {
    void save(User user);

    User findByName(String userName);
}
