package com.briup.kfc.impl.impl;

import com.briup.kfc.bean.OrderOnline;
import com.briup.kfc.bean.extend.OnlineDetails;
import com.briup.kfc.bean.extend.OrderDetails;
import com.briup.kfc.impl.IOrderOnline;
import com.briup.kfc.mapper.OrderOlineMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderOnlineImpl implements IOrderOnline {
    @Resource
    private OrderOlineMapper orderOlineMapper;


    @Override
    public void batchDelete(Long[] ids) {
        for(long id : ids){
            orderOlineMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<OnlineDetails> findAllDetails() {
        return orderOlineMapper.findAllDetails();
    }

    @Override
    public void saveOrUpdate(OrderOnline Order) {
        if(Order.getId()==null){
//保存
            orderOlineMapper.insert(Order);
        } else {
//通过id来修改
            orderOlineMapper.updateByPrimaryKeySelective(Order);
        }
    }


    @Override
    public void deleteById(long id) {
        orderOlineMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<OrderDetails> findById(long id) {
        return orderOlineMapper.findById(id);
    }


}
