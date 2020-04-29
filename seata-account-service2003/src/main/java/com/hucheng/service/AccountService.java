package com.hucheng.service;

import java.math.BigDecimal;


public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}
