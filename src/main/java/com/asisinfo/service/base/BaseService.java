package com.asisinfo.service.base;

import com.asisinfo.repository.base.BaseRepository;
import com.asisinfo.utils.MyPage;

import java.lang.reflect.ParameterizedType;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class BaseService<T,K> {

    private Class<K> clazz ;

    public BaseService(){
        //得到泛型话超类
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<K>) type.getActualTypeArguments()[1];
    }

    /**demo
     * @Override
     *       public  Predicate toPredicate(Root<TblCarton2RCardLog> root, CriteriaQuery<?> query,CriteriaBuilder cb) {
     *           List<Predicate> list = new ArrayList<Predicate>();
     *
     *           list.add(cb.equal(root.get("cartonNo").as(String.class), cartonNo));//某普通字段
     *
     *           list.add(cb.equal(root.get("id").get("rCard").as(String.class), rCard));//主键中某字段
     *
     *           list.add(cb.like(root.get("mocode").as(String.class), "%" + mocode + "%"));//like
     *
     *           list.add(cb.between(root.get("frozenDate").as(Long.class), frozenDateStart, frozenDateEnd));//between and
     *
     *           list.add(cb.greaterThanOrEqualTo(root.get("id").get("rcard").as(String.class), rCardStart));//大于等于
     *
     *           list.add(root.get("id").get("lotNo").as(String.class).in(lotNos));//in
     *
     *           //ORDER BY packdate DESC,packtime DESC
     *           Predicate[] p = new Predicate[list.size()];
     *           query.where(cb.and(list.toArray(p)));
     *           query.orderBy(cb.desc(root.get("packDate")),cb.desc(root.get("packTime")));
     *
     *           return query.getRestriction();
     *       }
     */
    /**
     * 分页查询
     * @param myPage
     * @param directio
     * @param sortField
     * @param spec
     * @param baseRepository
     * @return
     */
    public MyPage<T,K> findAllByPage(MyPage<T,K> myPage, Sort.Direction directio, String sortField,
                                           Specification<T> spec, BaseRepository baseRepository){
        Sort sort = new Sort(directio,sortField);
        Pageable pageable = new PageRequest(myPage.getPageNo(),myPage.getPageSize(),sort);
        Page<T> all;
        if(spec!=null){//有条件的查询
            all= baseRepository.findAll(spec, pageable);
        }else{
            all=baseRepository.findAll(pageable);
        }
        List<K> listVo=new ArrayList<K>(all.getContent().size());
        try {
            for(int i =0;i<all.getContent().size();i++){
                K k = clazz.newInstance();
                BeanUtils.copyProperties(all.getContent().get(i),k);
                listVo.add(k);
            }
        } catch (Exception e) {
        }
        myPage.setRecords(listVo);
        return myPage;
    }

    /**
     * 分页查询(默认asc，排序字段id)
     * @param myPage
     * @param spec
     * @param baseRepository
     * @return
     */
    public MyPage<T,K> findAllByPage(MyPage<T,K> myPage,Specification<T> spec, BaseRepository baseRepository){
        return findAllByPage(myPage,Sort.Direction.ASC,"id",spec,baseRepository);
    }
}
