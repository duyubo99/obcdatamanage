package com.asisinfo.repository;

import com.asisinfo.domain.User;
import com.asisinfo.repository.base.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
    User findByUsernameAndPassword(String name,String pwd);
}
