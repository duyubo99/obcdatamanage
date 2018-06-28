package com.asisinfo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 因为你需要序列化对象有一个属性是一类类型，而你使用了Hibernate的延迟加载所以这里是个Hibernate的代理对象。
 * 该代理对象有些属性不能被序列化所以会报错。
 *
 * 解决办法：在类型上加如下注解把不需要序列化的属性屏蔽掉
 * @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
 */
@Entity(name="USER")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User implements Serializable {

    public User(){
        super();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
