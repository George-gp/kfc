package com.briup.kfc.bean.extend;

import com.briup.kfc.bean.Order;
import com.briup.kfc.bean.User;

public class OrderandUser extends Order {
    private User user;
    public void setuser(User user) {
        this.user = user;
    }
    public User getuser() {
        return user;
    }
}
