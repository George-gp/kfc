package com.briup.kfc.impl;

import com.briup.kfc.bean.Role;

import java.util.List;

public interface IRole
{
    void batchDelete(Long[] ids);
    List<Role> findAll();
    void saveOrUpdate(Role Role);
    Role findById(long id);
    void deleteById(long id);
}
