package com.zerobase.convpay;

import com.zerobase.convpay.Type.ConvenienceType;
import com.zerobase.convpay.Type.PayMeyhodType;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편결이 -> 머니

        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // 결제 1000원
        PayRequest payRequest = new PayRequest(PayMeyhodType.CARD, ConvenienceType.G25, 1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);

        // 취소 500

        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMeyhodType.MONEY, ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);
    }
}
