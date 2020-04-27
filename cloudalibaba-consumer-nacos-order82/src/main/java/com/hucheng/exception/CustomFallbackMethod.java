package com.hucheng.exception;

import com.hucheng.bean.ResultInfo;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author HuChan
 */
public class CustomFallbackMethod {

    public static ResultInfo<String> customFallbackMethod1(String id) {
        return new ResultInfo(200, "别慌，正在修复", null);
    }
}
