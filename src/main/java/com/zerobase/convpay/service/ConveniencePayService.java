package com.zerobase.convpay.service;

import com.zerobase.convpay.Type.*;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;

@Component
public class ConveniencePayService {    // 편결이
    private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap =
            new HashMap<>();
    private final DiscountInterface discountInterface;

    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
                                 DiscountInterface discountByConvenience) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(
                        paymentInterface.getPayMethodType(),
                        paymentInterface
                )
        );
        this.discountInterface = discountByConvenience;
    }

    //    private final DiscountInterface discountInterface = new DiscountByPayMethod();


    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface =
                paymentInterfaceMap.get(payRequest.getPayMeyhodType());

        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);
        PaymentResult payment = paymentInterface.payment(discountedAmount);


        if (payment == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // Success Case
        return new PayResponse(PayResult.SUCCESS, discountedAmount);

    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface =
                paymentInterfaceMap.get(payCancelRequest.getPayMeyhodType());


        CancelPaymentResult cancelPaymentResult =
                paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        // Success Case
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
