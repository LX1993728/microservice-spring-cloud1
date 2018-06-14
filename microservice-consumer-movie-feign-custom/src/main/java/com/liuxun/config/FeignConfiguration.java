package com.liuxun.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    @Bean
    public Contract feignContract() {
        // 如果不设置默认FeignClient接口中使用SpringMVC契约(Contact)，这里使用的是Feign自己契约
        return new feign.Contract.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
