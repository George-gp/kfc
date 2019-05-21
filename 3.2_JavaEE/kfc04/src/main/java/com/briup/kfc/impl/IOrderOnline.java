package com.briup.kfc.impl;

import com.briup.kfc.bean.OrderOnline;
import com.briup.kfc.bean.extend.OnlineDetails;
import com.briup.kfc.bean.extend.OrderDetails;

import java.util.List;

public interface IOrderOnline {

    void batchDelete(Long[] ids);
    void saveOrUpdate(OrderOnline Order);
    void deleteById(long id);
    List<OrderDetails>findById(long id);
    List<OnlineDetails>findAllDetails();
}
