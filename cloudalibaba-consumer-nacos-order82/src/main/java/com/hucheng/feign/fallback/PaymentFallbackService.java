package com.hucheng.feign.fallback;

import com.hucheng.bean.ResultInfo;
import com.hucheng.feign.PaymentFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author HuChan
 */
@Component
public class PaymentFallbackService implements FallbackFactory<PaymentFeignService> {

    @Override
    public PaymentFeignService create(Throwable cause) {
        return id -> "别慌，正在修复";
    }
}
