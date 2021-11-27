package com.vrx.exam.service.impl;

import com.vrx.exam.model.User;
import com.vrx.exam.model.UserRole;
import com.vrx.exam.repo.RoleRepository;
import com.vrx.exam.repo.UserRepository;
import com.vrx.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User localUser = userRepository.findByUsername(user.getUsername());
        if(localUser != null){
            System.out.println("User is already there !!");
            throw new Exception("User already present !!");
        }else {
            //user create
            for (UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            localUser = this.userRepository.save(user);

        }

        return localUser;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public String deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null){
            return "User not present";
        }
        userRepository.deleteById(user.getId());
        return "User:" + username + " - deleted !";
    }
}
