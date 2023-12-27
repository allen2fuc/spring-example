package com.example.springexample;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

// Spring Boot 应用的入口类
@SpringBootApplication
public class SpringExampleApplication {

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        ConfigurableApplicationContext run = SpringApplication.run(SpringExampleApplication.class, args);
    }

    @Bean
    BeanPostProcessor beanPostProcessor(){
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                System.out.println(bean.getClass());
                return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
            }
        };
    }
}
