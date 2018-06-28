package com.asisinfo.service;

import com.asisinfo.domain.User;
import com.asisinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "user",cacheManager = "userCacheManager")
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public boolean isLogin(String username, String password) {
        User u=userRepository.findByUsernameAndPassword(username,password);
        if(u!=null){
            return true;
        }

        return false;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @CachePut(key = "#user.id")
    public User save(User user){
        return userRepository.save(user);
    }

    @Cacheable
    public User getUser(Integer id){
        return  userRepository.getOne(id);
    }
    @CacheEvict
    public void delete(Integer id){
        userRepository.delete(id);
    }


}
