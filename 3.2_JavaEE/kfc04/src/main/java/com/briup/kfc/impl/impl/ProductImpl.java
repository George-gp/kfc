package com.briup.kfc.impl.impl;

import com.briup.kfc.bean.Product;
import com.briup.kfc.bean.ProductExample;
import com.briup.kfc.impl.IProduct;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductImpl implements IProduct {
    @Resource
    private com.briup.kfc.mapper.ProductMapper ProductMapper;
    @Override
    public void batchDelete(Long[] ids) {
        for(long id : ids){
            ProductMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<Product> findAll() {
        ProductExample ProductExample=new ProductExample();
        return ProductMapper.selectByExample(ProductExample);
    }

    @Override
    public void saveOrUpdate(Product Product) {
        if(Product.getId()==null){
            //保存
            ProductMapper.insert(Product);
        } else {
            //通过id来修改
            ProductMapper.updateByPrimaryKeySelective(Product);
        }
    }

    @Override
    public Product findById(long id) {
        return ProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(long id) {
        ProductMapper.deleteByPrimaryKey(id);
    }
}
