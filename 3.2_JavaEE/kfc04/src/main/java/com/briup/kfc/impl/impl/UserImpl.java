package com.briup.kfc.impl.impl;
import com.briup.kfc.bean.User;
import com.briup.kfc.bean.UserExample;
import com.briup.kfc.bean.extend.UserandRole;
import com.briup.kfc.impl.IUser;
import com.briup.kfc.mapper.extend.UseRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserImpl implements IUser {
    @Resource
    private com.briup.kfc.mapper.UserMapper UserMapper;
    @Resource
    private UseRole useRole;
    @Override
    public void batchDelete(Long[] ids) {
        for(long id : ids){
            UserMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<User> findAll() {
        UserExample UserExample=new UserExample();
        return UserMapper.selectByExample(UserExample);
    }

    @Override
    public void saveOrUpdate(User User) {
        if(User.getId()==null){
            //保存
            UserMapper.insert(User);
        } else {
            //通过id来修改
            UserMapper.updateByPrimaryKeySelective(User);
        }
    }

    @Override
    public User findById(long id) {
        return UserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(long id) {
        UserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserandRole> userandrole() {

        return useRole.userandrole();
    }
//具体实现来自mapper里的方法调用，外围函数框架来自接口
}
