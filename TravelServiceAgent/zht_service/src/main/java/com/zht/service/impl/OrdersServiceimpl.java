package com.zht.service.impl;

import com.github.pagehelper.PageHelper;
import com.zht.dao.iOrdersDao;
import com.zht.domain.Orders;
import com.zht.domain.Traveller;
import com.zht.service.iOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
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
    public Orders findById(int ordersId) throws Exception
    {
        return ordersDao.findById(ordersId);
    }

    @Override
    public void save(Orders orders) throws Exception {
        ordersDao.save(orders);
        ordersDao.saveprice(orders);
    }

    @Override
    public List<Traveller> findOtherTravellers(int ordersId) throws Exception {
        return ordersDao.findOtherTravellers(ordersId);
    }

    @Override
    public void addTraveller(int ordersId, int[] travellerIds) throws Exception {
        for(int travellerId:travellerIds){
            ordersDao.addTraveller(ordersId,travellerId);
        }
    }

    @Override
    public void auditOrder(int ordersId) throws Exception {
        ordersDao.auditOrder(ordersId);
    }

    @Override
    public void closeOrder(int ordersId) throws Exception {
        ordersDao.closeOrderStatus(ordersId);
        ordersDao.closeOrderAudit(ordersId);
        ordersDao.closeOrderFinal(ordersId);
    }

}
