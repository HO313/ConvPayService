package com.zerobase.convpay.service;

import com.zerobase.convpay.Type.ConvenienceType;
import com.zerobase.convpay.Type.PayMethodType;
import com.zerobase.convpay.dto.PayRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test
    void discountSuccess() {
        //given
        PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY,
                ConvenienceType.G25, 1000);
        PayRequest payRequestCard = new PayRequest(PayMethodType.CARD,
                ConvenienceType.G25, 1000);

        //when
        Integer discountedAmountMoney =
                discountByPayMethod.getDiscountedAmount(payRequestMoney);
        Integer discountedAmountCard =
                discountByPayMethod.getDiscountedAmount(payRequestCard);

        //then
        assertEquals(700, discountedAmountMoney);
        assertEquals(1000, discountedAmountCard);
    }
}