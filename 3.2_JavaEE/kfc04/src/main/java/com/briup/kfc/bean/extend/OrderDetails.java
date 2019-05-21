package com.briup.kfc.bean.extend;

import com.briup.kfc.bean.Order;
import com.briup.kfc.bean.OrderOnline;
import com.briup.kfc.bean.Product;
import com.briup.kfc.bean.User;

public class OrderDetails extends OrderOnline {
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
