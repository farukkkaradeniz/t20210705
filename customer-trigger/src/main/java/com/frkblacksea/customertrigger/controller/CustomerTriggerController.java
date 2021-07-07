package com.frkblacksea.customertrigger.controller;

import com.frkblacksea.customertrigger.feign.CustomerFeignClient;
import com.frkblacksea.customertrigger.model.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer-trigger")
public class CustomerTriggerController {
    private final CustomerFeignClient customerFeignClient;

    public CustomerTriggerController(CustomerFeignClient customerFeignClient) {
        this.customerFeignClient = customerFeignClient;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok(this.customerFeignClient.getAll());
    }

    @PostMapping
    public ResponseEntity<ApiResponse> save(@RequestBody Object customerEntity)  {
        return ResponseEntity.ok(this.customerFeignClient.save(customerEntity));
    }
}
