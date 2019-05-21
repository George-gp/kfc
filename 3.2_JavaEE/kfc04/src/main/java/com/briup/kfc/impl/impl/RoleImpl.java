package com.briup.kfc.impl.impl;

import com.briup.kfc.bean.Role;
import com.briup.kfc.bean.RoleExample;
import com.briup.kfc.impl.IRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleImpl implements IRole {
    @Resource
    private com.briup.kfc.mapper.RoleMapper RoleMapper;
    @Override
    public void batchDelete(Long[] ids) {
        for(long id : ids){
            RoleMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<Role> findAll() {
        RoleExample RoleExample=new RoleExample();
        return RoleMapper.selectByExample(RoleExample);
    }

    @Override
    public void saveOrUpdate(Role Role) {
        if(Role.getId()==null){
            //保存
            RoleMapper.insert(Role);
        } else {
            //通过id来修改
            RoleMapper.updateByPrimaryKeySelective(Role);
        }
    }

    @Override
    public Role findById(long id) {
        return RoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(long id) {
        RoleMapper.deleteByPrimaryKey(id);
    }
}
