package com.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Getter
@Setter
@ToString
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer brandId;
    private String brandName;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private Integer status;
}
