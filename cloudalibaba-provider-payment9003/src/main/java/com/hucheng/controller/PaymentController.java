package com.hucheng.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuChan
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/payment/{id}")
    public String payment(@PathVariable String id) {
        if (id.equals("0")) {
            throw new RuntimeException("测试fallback异常");
        }
        return "payment " + port + " :" + id;
    }
}
