package com.hucheng.service;


import com.hucheng.bean.Order;

public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}