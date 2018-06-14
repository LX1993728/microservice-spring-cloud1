package com.liuxun.cloud;

import com.liuxun.config.FeignConfiguration2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "xxxxx",url = "http://localhost:8761/", configuration = FeignConfiguration2.class)
public interface FeignClient2 {
    @RequestMapping(value = "/eureka/apps/{serviceName}",method = RequestMethod.GET)
    String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName")String serviceName);
}
