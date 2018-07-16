package com.asisinfo.repository.base;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaSpecificationExecutor<T>,JpaRepository<T,Integer>
    ,CrudRepository<T,Integer> {
    /*
     * @Author: Mr.du
     * @Date: 2018/7/13 15:53
     * @Description:返回总记录数
     */
    long count();
}
