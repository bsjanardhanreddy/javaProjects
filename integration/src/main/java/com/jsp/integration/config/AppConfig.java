package com.jsp.integration.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableTransactionManagement
@ComponentScan(basePackages = "com.jsp.integration")
public class AppConfig { }
