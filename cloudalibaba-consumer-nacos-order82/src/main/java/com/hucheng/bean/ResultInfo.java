package com.hucheng.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HuChan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class ResultInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 操作代码
     */
    private int code = 0;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;
}