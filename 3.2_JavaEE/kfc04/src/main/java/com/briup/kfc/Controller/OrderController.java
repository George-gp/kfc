package com.briup.kfc.Controller;

import com.briup.kfc.bean.Order;
import com.briup.kfc.impl.IOrder;
import com.briup.kfc.mapper.extend.OrderUser;
import com.briup.kfc.utils.Message;
import com.briup.kfc.utils.MessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/Order")
public class OrderController {
    @Resource
    private IOrder iOrder;
    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody Long[] ids) {
        iOrder.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("findAll")
    public Message findAll(){
        List<Order> all = iOrder.findAll();
        return MessageUtil.success(all);
    }

    @GetMapping("findById")
    public Message findById(long id) {
        Order course = iOrder.findById(id);
        return MessageUtil.success(course);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Order order){
        iOrder.saveOrUpdate(order);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("Delete")
    public Message deleteById(long id)
    {
        iOrder.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @GetMapping("orderanduser")
    public Message orderanduser()
    {
        List<OrderUser> orderanduser = iOrder.orderanduser();
        return MessageUtil.success(orderanduser);
    }


}
