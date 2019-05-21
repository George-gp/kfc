package com.briup.kfc.bean.extend;

import com.briup.kfc.bean.Role;
import com.briup.kfc.bean.User;

public class UserandRole extends User {
    private Role role;
    public void setrole(Role role) {
        this.role = role;
    }
    public Role getrole() {
        return role;
    }
}
