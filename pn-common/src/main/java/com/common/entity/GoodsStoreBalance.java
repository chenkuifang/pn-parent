package com.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品库存平衡实体类
 *
 * @author QuiFar
 * @version V1.0
 **/
@Data
public class GoodsStoreBalance implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer goodsId;
    private Integer inCount;
    private Integer outCount;
    private Date createTime;
    private Integer createUser;

}
