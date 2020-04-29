package com.hucheng.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author HuChan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;

    private Long userId;

    private BigDecimal total;

    private BigDecimal used;

    private BigDecimal  residue;
}