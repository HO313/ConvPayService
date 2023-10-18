package com.zerobase.convpay.service;

import com.zerobase.convpay.Type.CancelPaymentResult;
import com.zerobase.convpay.Type.PayMethodType;
import com.zerobase.convpay.Type.PaymentResult;

public interface PaymentInterface {
    PayMethodType getPayMethodType();
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);

}
