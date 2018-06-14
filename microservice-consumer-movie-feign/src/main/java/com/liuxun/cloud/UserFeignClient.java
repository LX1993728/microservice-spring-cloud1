package com.liuxun.cloud;

import com.liuxun.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {
    //注意: FeignClient接口方法不支持@GetMapping，如果使用Restful风格与路径中对应的变量必须添加@PathVariable注解，@RequestMapping参数必须指明请求类型
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User postUser(@RequestBody User user);

    // 该请求不会成功，只要参数时复杂对象，即使指定了GET方法，Feign依然会以post方法进行发送请求
//    @RequestMapping(value = "/get-user", method = RequestMethod.GET)
//    public User getUser(User user);

    // 可以使用以下方法替代
    @RequestMapping(value = "/get-user", method = RequestMethod.GET)
    public User getUser(@RequestParam("id")Long id,@RequestParam("username")String username);

}
