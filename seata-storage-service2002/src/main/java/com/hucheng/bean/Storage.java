package com.hucheng.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HuChan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Long id;

    private Integer total;

    private Integer used;

    private Integer  residue;
}
