package com.briup.kfc.impl;

import com.briup.kfc.bean.User;
import com.briup.kfc.bean.extend.UserandRole;

import java.util.List;

//这是框架
public interface IUser {
    void batchDelete(Long[] ids);
    List<User> findAll();
    void saveOrUpdate(User User);
    User findById(long id);
    void deleteById(long id);
    List<UserandRole> userandrole();
}
