package com.hucheng.exception;

import com.hucheng.bean.ResultInfo;

/**
 * @author HuChan
 */
public class CustomBlockMethod {
    public static ResultInfo<String> customBlockMethod1(String id) {
        return new ResultInfo(200, "服务器，等等在访问", null);
    }
}
