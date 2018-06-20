package com.asisinfo.repository;

import com.asisinfo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsernameAndPassword(String name,String pwd);
}
