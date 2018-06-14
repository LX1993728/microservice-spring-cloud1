package com.liuxun.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${profile}")
    private String profile;

    @Value("${global}")
    private String global;

    @GetMapping("/profile")
    public String getProfile(){
        return this.profile+" "+global;
    }
}