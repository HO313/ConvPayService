package com.zerobase.convpay.service;

import com.zerobase.convpay.Type.ConvenienceType;
import com.zerobase.convpay.Type.PayMeyhodType;
import com.zerobase.convpay.dto.PayRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience = new DiscountByConvenience();
    @Test
    void discountTest() {
        //given
        PayRequest payRequestG25 = new PayRequest(PayMeyhodType.MONEY, ConvenienceType.G25, 1000);
        PayRequest payRequestCU = new PayRequest(PayMeyhodType.MONEY, ConvenienceType.CU, 1000);
        PayRequest payRequestSEVEN = new PayRequest(PayMeyhodType.MONEY, ConvenienceType.SEVEN, 1000);

        //when
        Integer discountedAmountG25 = discountByConvenience.getDiscountedAmount(payRequestG25);
        Integer discountedAmountCU = discountByConvenience.getDiscountedAmount(payRequestCU);
        Integer discountedAmountSEVEN = discountByConvenience.getDiscountedAmount(payRequestSEVEN);

        //then
        assertEquals(800, discountedAmountG25);
        assertEquals(900, discountedAmountCU);
        assertEquals(1000, discountedAmountSEVEN);
    }

}