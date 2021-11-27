package com.vrx.exam.controller;

import com.vrx.exam.model.Role;
import com.vrx.exam.model.User;
import com.vrx.exam.model.UserRole;
import com.vrx.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user){

        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRoles.add(userRole);
        user.setUserRoles(userRoles);

        try {
            return userService.createUser(user,userRoles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //get user
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return userService.getUser(username);
    }

    //delete user by username
    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable("username") String username){
        return userService.deleteUser(username);
    }

}
