package com.briup.kfc.Controller;

import com.briup.kfc.bean.User;
import com.briup.kfc.bean.extend.UserandRole;
import com.briup.kfc.impl.IUser;
import com.briup.kfc.utils.Message;
import com.briup.kfc.utils.MessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Resource
    private IUser iUser;
    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody Long[] ids) {
        iUser.batchDelete(ids);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("findAll")
    public Message findAll(){
        List<User> list = iUser.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("findById")
    public Message findById(long id) {
        User course = iUser.findById(id);
        return MessageUtil.success(course);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(User User){
        iUser.saveOrUpdate(User);
        return MessageUtil.success("操作成功");
    }

    @PostMapping("Delete")
    public Message deleteById(long id)
    {
        iUser.deleteById(id);
        return MessageUtil.success("删除成功");
    }
    @GetMapping("userandrole")
    public Message userandrole()
    {
        List<UserandRole> userandrole = iUser.userandrole();
        return MessageUtil.success(userandrole);
    }
}
