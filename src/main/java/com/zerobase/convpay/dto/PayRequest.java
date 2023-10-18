package com.zerobase.convpay.dto;

import com.zerobase.convpay.Type.ConvenienceType;
import com.zerobase.convpay.Type.PayMeyhodType;

public class PayRequest {
    // 결제 수단
    PayMeyhodType payMeyhodType;


    // 편의점 종류
    ConvenienceType convenienceType;
    // 결제 금액
    Integer payAmount;

    public PayRequest(PayMeyhodType payMeyhodType, ConvenienceType convenienceType, Integer payAmount) {
        this.payMeyhodType = payMeyhodType;
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
    }

    public PayMeyhodType getPayMeyhodType() {
        return payMeyhodType;
    }

    public void setPayMeyhodType(PayMeyhodType payMeyhodType) {
        this.payMeyhodType = payMeyhodType;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }
}
