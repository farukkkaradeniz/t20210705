package com.frkblacksea.customertrigger.feign;

import com.frkblacksea.customertrigger.model.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("CUSTOMER")
@RequestMapping("/api/v1/customer")
public interface CustomerFeignClient {
    @GetMapping
    public ApiResponse getAll();

    @PostMapping
    public ApiResponse save(@RequestBody Object customerEntity);
}
