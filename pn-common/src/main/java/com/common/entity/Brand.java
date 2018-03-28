package com.common.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品品牌实体类
 *
 * @author QuiFar
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer brandId;
    private String brandName;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
