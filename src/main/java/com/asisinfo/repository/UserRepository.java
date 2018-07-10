package com.asisinfo.repository;

import com.asisinfo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsernameAndPassword(String name,String pwd);

    Page<User> findAll(Pageable pageable);
}
