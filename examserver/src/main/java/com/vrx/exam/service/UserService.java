package com.vrx.exam.service;

import com.vrx.exam.model.User;
import com.vrx.exam.model.UserRole;

import java.util.Set;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    public String deleteUser(String username);
}
