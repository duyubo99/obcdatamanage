package com.asisinfo.service;

import com.asisinfo.domain.User;
import com.asisinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<User>{

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
        return super.findAllByPage(0,5,Sort.Direction.ASC,"id",userRepository);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User getUser(Integer id){
        return  userRepository.getOne(id);
    }

    public void delete(Integer id){
        userRepository.delete(id);
    }


}
