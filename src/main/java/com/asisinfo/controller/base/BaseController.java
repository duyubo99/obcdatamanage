package com.asisinfo.controller.base;

import com.asisinfo.domain.User;
import com.asisinfo.utils.MyPage;

/**
 * @Description:
 * @Author: Mr.du
 * @Date: 2018/7/13 16:54
 */
public class BaseController<T,K> {
    protected MyPage<T,K> page;

    public BaseController(){
        page=new MyPage<T,K>();
    }

    public MyPage<T, K> getPage() {
        return page;
    }

    public void setPage(MyPage<T, K> page) {
        this.page = page;
    }
}
