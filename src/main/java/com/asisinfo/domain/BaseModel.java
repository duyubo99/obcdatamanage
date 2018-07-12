package com.asisinfo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 因为你需要序列化对象有一个属性是一类类型，而你使用了Hibernate的延迟加载所以这里是个Hibernate的代理对象。
 * 该代理对象有些属性不能被序列化所以会报错。
 *
 * 解决办法：在类型上加如下注解把不需要序列化的属性屏蔽掉
 * @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = -6391445021378844473L;

    public abstract Integer getId();

    public abstract void setId(Integer id) ;

    public String toString() {
        try {
            StringBuffer buffer = new StringBuffer();
            Class clazz = this.getClass();
            String simpleName = clazz.getSimpleName();
            buffer.append(simpleName);
            buffer.append("{");
            //
            Field[] fs = clazz.getDeclaredFields();
            Class ftype = null ;
            String fname = null ;
            Object fvalue = null ;
            for(Field f : fs){
                ftype = f.getType();
                fname = f.getName();
                f.setAccessible(true);
                fvalue = f.get(this);
                //是否是基本数据类型
                if((ftype.isPrimitive()
                        ||ftype == Integer.class
                        ||ftype == Long.class
                        ||ftype == Short.class
                        ||ftype == Boolean.class
                        ||ftype == Character.class
                        ||ftype == Double.class
                        ||ftype == Float.class
                        ||ftype == String.class)
                        && !Modifier.isStatic(f.getModifiers())
                        ){
                    buffer.append(fname);
                    buffer.append(":");
                    buffer.append(fvalue);
                    buffer.append(",");
                }
            }
            //
            buffer.append("{}");
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
