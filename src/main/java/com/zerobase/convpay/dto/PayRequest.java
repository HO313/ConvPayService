package com.zerobase.convpay.dto;

import com.zerobase.convpay.Type.ConvenienceType;
import com.zerobase.convpay.Type.PayMethodType;

public class PayRequest {
    // 결제 수단
    PayMethodType payMeyhodType;


    // 편의점 종류
    ConvenienceType convenienceType;
    // 결제 금액
    Integer payAmount;

    public PayRequest(PayMethodType payMeyhodType, ConvenienceType convenienceType, Integer payAmount) {
        this.payMeyhodType = payMeyhodType;
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
    }

    public PayMethodType getPayMeyhodType() {
        return payMeyhodType;
    }

    public void setPayMeyhodType(PayMethodType payMeyhodType) {
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
