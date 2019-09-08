package com.yidu.order.domain;

import java.math.BigDecimal;
import java.util.Date;

public class YiduProduct {
    private String proId;

    private String proTypeId;

    private String proName;

    private BigDecimal proPrice;

    private String proColor;

    private String proRemark;

    private Integer isva;

    private Date optime;

    private String oper;

    private Integer sort;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getProTypeId() {
        return proTypeId;
    }

    public void setProTypeId(String proTypeId) {
        this.proTypeId = proTypeId == null ? null : proTypeId.trim();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public BigDecimal getProPrice() {
        return proPrice;
    }

    public void setProPrice(BigDecimal proPrice) {
        this.proPrice = proPrice;
    }

    public String getProColor() {
        return proColor;
    }

    public void setProColor(String proColor) {
        this.proColor = proColor == null ? null : proColor.trim();
    }

    public String getProRemark() {
        return proRemark;
    }

    public void setProRemark(String proRemark) {
        this.proRemark = proRemark == null ? null : proRemark.trim();
    }

    public Integer getIsva() {
        return isva;
    }

    public void setIsva(Integer isva) {
        this.isva = isva;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper == null ? null : oper.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}