package com.hucheng.feign;

import com.hucheng.bean.ResultInfo;
import com.hucheng.feign.fallback.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author HuChan
 */
@FeignClient(value = "nacos-payment-provider", fallbackFactory = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping(value = "/payment/{id}")
    String paymentInfo(@PathVariable("id") String id);

}
