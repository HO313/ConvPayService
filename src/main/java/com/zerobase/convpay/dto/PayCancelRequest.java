package com.zerobase.convpay.dto;

import com.zerobase.convpay.Type.ConvenienceType;
import com.zerobase.convpay.Type.PayMethodType;

public class PayCancelRequest {

    // 결제 수단
    PayMethodType payMeyhodType;
    // 편의점 종류
    ConvenienceType convenienceType;
    // 결제 취소 금액
    Integer payCancelAmount;

    public PayCancelRequest(PayMethodType payMeyhodType, ConvenienceType convenienceType, Integer payCancelAmount) {
        this.payMeyhodType = payMeyhodType;
        this.convenienceType = convenienceType;
        this.payCancelAmount = payCancelAmount;
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

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }

}
