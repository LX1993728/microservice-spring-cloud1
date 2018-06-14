package com.liuxun.cloud.feign;

import com.liuxun.cloud.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient>{

    private static final Logger log = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        log.info("Fallback Reason is {} ", throwable.getMessage());
        return new HystrixUserClientWithFallBackFactory() {
            @Override
            public User findById(Long id) {
                User user = new User();
                user.setId(-1L);
                return user;
            }
        };
    }
}
