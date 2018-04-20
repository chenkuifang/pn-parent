
package com.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息实体类
 *
 * @author ：QuiFar
 */
@Getter
@Setter
@ToString
public class Order implements Serializable {

    private static final long serialVersionUID = -1920269264219788549L;
    private Integer orderId; /* 订单编码 */
    private String orderSid; /* 订单号 */
    private String paySid;
    private Integer payWay;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;
    private String goodsNum; /* 商品编码 */
    private String goodsName; /* 商品名称 */
    private BigDecimal price; /* 拍下价格 */
    private BigDecimal payPrice; /* 支付价格 */
    private Integer amount; /* 商品数量 */
    private String buyerName; /* 收货人 */
    private String buyerAddress; /* 收货地址 */
    private String buyerPhone; /* 手机 */
    private Integer createId; /* 订单创建账号ID */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; /* 订单创建时间 */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime; /* 订单最后修改时间 */
    private Integer status; /* 订单状态 0:未付款，1：已付款，2：已发货，3：已完成，4：取消订单 */
}