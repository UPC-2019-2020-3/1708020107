package com.zht.service.impl;

import com.github.pagehelper.PageHelper;
import com.zht.dao.iOrdersDao;
import com.zht.domain.Orders;
import com.zht.service.iOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class OrdersServiceimpl implements iOrdersService {

    @Autowired
    private iOrdersDao ordersDao;

    @Override
    public List<Orders> findAllOrders() throws Exception {
        return ordersDao.findAllOrders();
    }

    @Override
    public List<Orders> findAll(int pageNum, int pageSize) throws Exception {
        // 参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return  ordersDao.findAll(pageNum, pageSize);
    }

    @Override
    public Orders findById(int ordersId) throws Exception{
        return ordersDao.findById(ordersId);
    }
}
