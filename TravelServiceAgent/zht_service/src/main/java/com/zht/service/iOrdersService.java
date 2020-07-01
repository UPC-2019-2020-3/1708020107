package com.zht.service;

import com.zht.domain.Orders;

import java.util.List;

public interface iOrdersService {

    List<Orders> findAllOrders() throws Exception;

    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
