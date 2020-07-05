package com.zht.service;

import com.zht.domain.Orders;

import java.sql.SQLException;
import java.util.List;

public interface iOrdersService {

    List<Orders> findAllOrders() throws Exception;

    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(int ordersId) throws Exception;

    void save(Orders orders) throws Exception;
}
