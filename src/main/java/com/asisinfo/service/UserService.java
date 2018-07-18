package com.asisinfo.service;

import com.asisinfo.domain.User;
import com.asisinfo.repository.UserRepository;
import com.asisinfo.service.base.BaseService;
import com.asisinfo.utils.MyPage;
import com.asisinfo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends BaseService<User,UserVo> {

    @Autowired
    private UserRepository userRepository;

    public boolean isLogin(String username, String password) {
        User u=userRepository.findByUsernameAndPassword(username,password);
        if(u!=null){
            return true;
        }
        return false;
    }
    public MyPage<User,UserVo> findAll(MyPage<User,UserVo> page){
        UserVo vo =page.getQueryModel();
        if(vo.getUsername()==null&&vo.getId()==null){//条件为空时
            return findAllByPage(page,null,userRepository);
        }
        Specification<User> spec=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(vo.getUsername()!=null){
                    list.add( cb.like(root.get("username"), "%"+vo.getUsername()+"%"));
                }
                if(vo.getId()!=null&&!vo.getId().equals("")){
                    list.add( cb.equal(root.get("id"), vo.getId()));
                }
                Predicate[] p = new Predicate[list.size()];
                query.where(cb.and(list.toArray(p)));
                return query.getRestriction();
            }
        };
        return findAllByPage(page,spec,userRepository);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User getUser(Integer id){
        return  userRepository.findOne(id);
    }

    public void delete(Integer id){
        userRepository.delete(id);
    }

    public void deleteBatchByid(String ids){
        super.deleteBatchByid(ids,userRepository);
    }


}
