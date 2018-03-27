package com.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品实体类
 *
 * @author QuiFar
 * @version V1.0
 **/
public class Goods implements Serializable {

    private static final long serialVersionUID = -8631597948477729776L;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsNum='" + goodsNum + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", salePrice=" + salePrice +
                ", discountPrice=" + discountPrice +
                ", stock=" + stock +
                ", saleCount=" + saleCount +
                ", status=" + status +
                ", brandId=" + brandId +
                ", brand=" + brand +
                '}';
    }
}
