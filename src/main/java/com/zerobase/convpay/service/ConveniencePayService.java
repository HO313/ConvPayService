package com.zerobase.convpay.service;

import com.zerobase.convpay.Type.*;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;

public class ConveniencePayService {    // 편결이
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();
//    private final DiscountInterface discountInterface = new DiscountByPayMethod();
    private final DiscountInterface discountInterface = new DiscountByConvenience();

ㅠ
    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface;

        if (payRequest.getPayMeyhodType() == PayMeyhodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
        PaymentResult payment = paymentInterface.payment(discountedAmount);


        if (payment == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // Success Case
        return new PayResponse(PayResult.SUCCESS, discountedAmount);

    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if (payCancelRequest.getPayMeyhodType() == PayMeyhodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }


        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        // Success Case
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
