package com.zerobase.convpay;

import com.zerobase.convpay.Type.ConvenienceType;
import com.zerobase.convpay.Type.PayMethodType;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편결이 -> 머니

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config.xml");

        ConveniencePayService conveniencePayService =
                applicationContext.getBean("conveniencePayService",
                        ConveniencePayService.class);

        // 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.CARD,
                ConvenienceType.G25, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);

        // 취소 500

        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY,
                ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);
    }
}
