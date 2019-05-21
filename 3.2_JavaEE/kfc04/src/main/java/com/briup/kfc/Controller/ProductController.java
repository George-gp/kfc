package com.briup.kfc.Controller;

import com.briup.kfc.bean.Product;
import com.briup.kfc.impl.IProduct;
import com.briup.kfc.utils.Message;
import com.briup.kfc.utils.MessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Resource
    private IProduct iProduct;
    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody Long[] ids) {
        iProduct.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("findAll")
    public Message findAll(){
        List<Product> list = iProduct.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("findById")
    public Message findById(long id) {
        Product course = iProduct.findById(id);
        return MessageUtil.success(course);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Product Product){
        iProduct.saveOrUpdate(Product);
        return MessageUtil.success("操作成功");
    }

    @PostMapping("Delete")
    public Message deleteById(long id)
    {
        iProduct.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
