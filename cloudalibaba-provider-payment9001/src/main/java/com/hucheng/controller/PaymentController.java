package com.hucheng.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuChan
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("server.port")
    private String port;

    @GetMapping("/{id}")
    public String getPortInfo(@PathVariable String id) {
        return "Nacos Provider port: " + port + " NO." + id;
    }
}
