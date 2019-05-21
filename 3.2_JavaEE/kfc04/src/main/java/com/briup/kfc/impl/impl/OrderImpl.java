package com.briup.kfc.impl.impl;

import com.briup.kfc.bean.Order;
import com.briup.kfc.bean.OrderExample;
import com.briup.kfc.impl.IOrder;
import com.briup.kfc.mapper.OrderMapper;
import com.briup.kfc.mapper.extend.OrderUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderImpl implements IOrder {
@Resource
private OrderMapper orderMapper;
@Resource
private OrderUser orderUser;

@Override
public void batchDelete(Long[] ids) {
for(long id : ids){
orderMapper.deleteByPrimaryKey(id);
}
}
@Override
public List<Order> findAll() {
OrderExample orderExample=new OrderExample();
return orderMapper.selectByExample(orderExample);
}

@Override
public void saveOrUpdate(Order Order) {
if(Order.getId()==null){
//保存
orderMapper.insert(Order);
} else {
//通过id来修改
orderMapper.updateByPrimaryKeySelective(Order);
}
}
@Override
public Order findById(long id) {

    return orderMapper.selectByPrimaryKey(id);
}

@Override
public void deleteById(long id) {
orderMapper.deleteByPrimaryKey(id);
}

    @Override
    public List<OrderUser> orderanduser() {
        return orderUser.orderanduser();
    }




}
