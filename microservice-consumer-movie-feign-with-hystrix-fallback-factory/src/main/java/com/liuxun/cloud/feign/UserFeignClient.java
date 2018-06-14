package com.liuxun.cloud.feign;

import com.liuxun.cloud.entity.User;
import com.liuxun.config.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

//  注意：fallbackFactory实际上是Fallback的增强版，是不能和fallback同时使用的。
@FeignClient(value = "microservice-provider-user",
        fallbackFactory =HystrixClientFallbackFactory .class,
        /*fallback = HystrixClientFallback.class,*/
        configuration = FeignConfiguration.class)
public interface UserFeignClient {
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}

