package com.briup.kfc.impl;

import com.briup.kfc.bean.Order;
import com.briup.kfc.mapper.extend.OrderUser;

import java.util.List;

public interface IOrder {

    void batchDelete(Long[] ids);
    List<Order> findAll();
    void saveOrUpdate(Order Order);
    Order findById(long id);
    void deleteById(long id);
    List<OrderUser> orderanduser();


}
