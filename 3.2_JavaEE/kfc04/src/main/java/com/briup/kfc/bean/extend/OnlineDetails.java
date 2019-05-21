package com.briup.kfc.bean.extend;


import com.briup.kfc.bean.Order;
import com.briup.kfc.bean.OrderOnline;
import com.briup.kfc.bean.Product;
import com.briup.kfc.bean.User;


public class OnlineDetails extends  OrderOnline{


    private User user;
    public void setuser(User user) {
        this.user = user;
    }
    public User getuser() {
        return user;
    }

    private Order order;
    public void setorder(Order order) {
        this.order = order;
    }
    public Order getorder() {
        return order;
    }

    private Product product;
    public void setproduct(Product product) {
        this.product = product;
    }
    public Product getproduct() {
        return product;
    }


}
