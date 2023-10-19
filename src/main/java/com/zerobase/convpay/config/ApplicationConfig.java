package com.zerobase.convpay.config;

import com.zerobase.convpay.service.ConveniencePayService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ConveniencePayService.class)
public class ApplicationConfig {

}
