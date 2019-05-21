package com.briup.kfc.impl;


import com.briup.kfc.bean.Product;

import java.util.List;

public interface IProduct {
    void batchDelete(Long[] ids);
    List<Product> findAll();
    void saveOrUpdate(Product product);
    Product findById(long id);
    void deleteById(long id);
}
