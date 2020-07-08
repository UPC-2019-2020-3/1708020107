package com.zht.service.impl;

import com.github.pagehelper.PageHelper;
import com.zht.dao.iProductDao;
import com.zht.domain.Product;
import com.zht.service.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional


public class ProductServiceimpl implements iProductService {

    @Autowired
    private iProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public void deleteProductById(int productId) throws Exception {
        productDao.deleteRoleById(productId);
    }

    @Override
    public void deleteProducts(int[] productIds) throws Exception{
        for(int productId:productIds){
            productDao.deleteProducts(productId);
        }
    }

    @Override
    public Product findById(int productId) throws Exception {
        return productDao.findById(productId);
    }

    @Override
    public void addReturn(int orderId, String productReturn) throws Exception {
        productDao.addReturn(orderId,productReturn);
        productDao.resetOrderStatus(orderId);
    }

    @Override
    public void openProductById(int productId) throws Exception {
        productDao.openProductById(productId);
    }
}
