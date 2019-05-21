package com.briup.kfc.Controller;


import com.briup.kfc.bean.OrderOnline;
import com.briup.kfc.bean.extend.OnlineDetails;
import com.briup.kfc.bean.extend.OrderDetails;
import com.briup.kfc.impl.IOrderOnline;
import com.briup.kfc.utils.Message;
import com.briup.kfc.utils.MessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/OrderDetails")
public class OrderDetailsController {
    @Resource
    private IOrderOnline iOrderOnline;
    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody Long[] ids) {
        iOrderOnline.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(OrderOnline order){
        iOrderOnline.saveOrUpdate(order);
        return MessageUtil.success("操作成功");
    }

    @PostMapping("Delete")
    public Message deleteById(long id)
    {
        iOrderOnline.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("findAll")
    public Message findAll(){
        List<OnlineDetails> all = iOrderOnline.findAllDetails();

        return MessageUtil.success(all);
    }

    @GetMapping("findById")
    public Message findById(long id){
        List<OrderDetails> byId = iOrderOnline.findById(id);
        return MessageUtil.success(byId);
    }



}

