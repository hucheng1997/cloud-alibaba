package com.hucheng.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.hucheng.bean.ResultInfo;
import com.hucheng.exception.CustomBlockMethod;
import com.hucheng.exception.CustomFallbackMethod;
import com.hucheng.feign.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author HuChan
 */
@RestController
@RequestMapping("/order")
public class ConsumerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PaymentFeignService paymentService;

    @RequestMapping("/ribbon/{id}")
    @SentinelResource(value = "fallback", fallbackClass = CustomFallbackMethod.class, fallback = "customFallbackMethod1",
            blockHandlerClass = CustomBlockMethod.class, defaultFallback = "customBlockMethod1"
    )
    public ResultInfo<String> consumerTest(@PathVariable String id) {
        String result = restTemplate.getForObject(SERVICE_URL + "/payment/" + id, String.class, id);
        if (id.equals("0")) {
            throw new NullPointerException("非法的id");
        }
        return new ResultInfo<>(200, "查询成功", result);
    }


    @RequestMapping("/feign/{id}")
    public ResultInfo<String> consumerFeignTest(@PathVariable String id) {
        String result = paymentService.paymentInfo(id);
        return new ResultInfo<>(200, "查询成功", result);
    }

}
