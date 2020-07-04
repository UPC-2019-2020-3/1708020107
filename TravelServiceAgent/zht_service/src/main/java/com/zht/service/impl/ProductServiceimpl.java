package com.zht.service.impl;

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
    public void deleteProductById(int productId) {
        productDao.deleteRoleById(productId);
    }
}
