package com.zerobase.convpay.dto;

import com.zerobase.convpay.Type.ConvenienceType;
import com.zerobase.convpay.Type.PayMeyhodType;

public class PayCancelRequest {

    // 결제 수단
    PayMeyhodType payMeyhodType;


    public PayMeyhodType getPayMeyhodType() {
        return payMeyhodType;
    }

    public void setPayMeyhodType(PayMeyhodType payMeyhodType) {
        this.payMeyhodType = payMeyhodType;
    }

    // 편의점 종류
    ConvenienceType convenienceType;

    // 결제 취소 금액
    Integer payCancelAmount;

    public PayCancelRequest(PayMeyhodType payMeyhodType, ConvenienceType convenienceType, Integer payCancelAmount) {
        this.payMeyhodType = payMeyhodType;
        this.convenienceType = convenienceType;
        this.payCancelAmount = payCancelAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }

}
