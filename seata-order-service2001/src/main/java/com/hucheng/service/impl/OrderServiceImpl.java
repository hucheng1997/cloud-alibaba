package com.hucheng.service.impl;

import com.hucheng.bean.Order;
import com.hucheng.mapper.OrderDao;
import com.hucheng.service.AccountService;
import com.hucheng.service.OrderService;
import com.hucheng.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HuChan
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderDao orderDao;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("新建订单：" + order.getId());
        orderDao.create(order);
        log.info("扣库存开始-----------");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("账户开始扣费-----");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("修改订单状态-------");
        orderDao.update(order.getUserId(), 0);
        log.info("订单处理完成");
    }
}
