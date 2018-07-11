package com.asisinfo.service;

import com.asisinfo.domain.BaseModel;
import com.asisinfo.domain.User;
import com.asisinfo.repository.UserRepository;
import com.asisinfo.repository.base.BaseRepository;
import com.asisinfo.service.base.BaseService;
import com.asisinfo.utils.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BaseService<User> {

    @Autowired
    private UserRepository userRepository;

    public boolean isLogin(String username, String password) {
        User u=userRepository.findByUsernameAndPassword(username,password);
        if(u!=null){
            return true;
        }
        return false;
    }
    public List<User> findAll(User u){
        if(u==null){
        }
        MyPage<User> page = new MyPage<User>();
        page.setPageNo(0);
        page.setPageSize(5);
        Specification<User> spec=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                Path<String> name = root.get("name");
//　　　　　　　　Path<Integer> age = root.get("age");
//　　　　　　　　Predicate p1 = cb.like(name, "%"+param.getName()+"%");
//　　　　　　　　Predicate p2 = cb.lt(age, param.getAge());
//    　　　　　　Predicate p = cb.and(p1, p2);
                return null;
            }
        };
        return findAllByPage(page,null,null,null,userRepository).getRecords();
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
