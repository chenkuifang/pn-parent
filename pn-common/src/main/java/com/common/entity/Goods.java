package com.common.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品实体类
 *
 * @author QuiFar
 * @version V1.0
 **/
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Goods implements Serializable {
	
	private static final long serialVersionUID = -532673284736785889L;
	
    private Integer id;
    private String goodsNum;
    private String goodsName;
    private BigDecimal salePrice;
    private BigDecimal discountPrice;
    private Integer stock;
    private Integer saleCount;
    private Integer status;
    private Integer brandId;

    /**品牌*/
    private Brand brand;
}
