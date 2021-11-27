package com.vrx.exam.repo;

import com.vrx.exam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
    public User findByUsername(String username);

    public void deleteByUsername(String username);
}
