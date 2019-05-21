package com.briup.kfc.Controller;

import com.briup.kfc.bean.Role;
import com.briup.kfc.impl.IRole;
import com.briup.kfc.utils.Message;
import com.briup.kfc.utils.MessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Role")
public class RoleController {
    @Resource
    private IRole iRole;
    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody Long[] ids) {
        iRole.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("findAll")
    public Message findAll(){
        List<Role> list = iRole.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("findById")
    public Message findById(long id) {
        Role course = iRole.findById(id);
        return MessageUtil.success(course);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Role Role){
        iRole.saveOrUpdate(Role);
        return MessageUtil.success("操作成功");
    }

    @PostMapping("Delete")
    public Message deleteById(long id)
    {
        iRole.deleteById(id);
        return MessageUtil.success("删除成功");
    }
}
