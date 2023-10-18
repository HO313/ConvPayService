package com.zerobase.convpay.service;

import com.zerobase.convpay.Type.ConvenienceType;
import com.zerobase.convpay.Type.PayCancelResult;
import com.zerobase.convpay.Type.PayMeyhodType;
import com.zerobase.convpay.Type.PayResult;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConveniencePayServiceTest {
    ConveniencePayService conveniencePayService = new ConveniencePayService();

    @Test
    void pay_success() {
        //given
        PayRequest payRequest = new PayRequest(PayMeyhodType.MONEY,ConvenienceType.G25, 50);

        //when
        PayResponse payResonse = conveniencePayService.pay(payRequest);

        //then
        assertEquals(PayResult.SUCCESS, payResonse.getPayResult());
        assertEquals(50, payResonse.getPaidAmount());
    }

    @Test
    void pay_fail() {
        //given
        PayRequest payRequest = new PayRequest(PayMeyhodType.MONEY,ConvenienceType.G25, 1000_001);

        //when
        PayResponse payResonse = conveniencePayService.pay(payRequest);

        //then
        assertEquals(PayResult.FAIL, payResonse.getPayResult());
        assertEquals(0, payResonse.getPaidAmount());
    }

    @Test
    void pay_cancel_success() {
        //given
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMeyhodType.MONEY,ConvenienceType.G25, 1000);

        //when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        //then
        assertEquals(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelResponse.getPayCancelResult());
        assertEquals(1000, payCancelResponse.getPayCanceledAmount());
    }

    @Test
    void pay_cacnel_fail() {
        //given
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMeyhodType.MONEY,ConvenienceType.G25, 99);

        //when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        //then
        assertEquals(PayCancelResult.PAY_CANCEL_FAIL, payCancelResponse.getPayCancelResult());
        assertEquals(0, payCancelResponse.getPayCanceledAmount());
    }

}