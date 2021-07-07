package com.frkblacksea.customer.controller;

import com.frkblacksea.customer.domain.CustomerEntity;
import com.frkblacksea.customer.exception.CustomerNotFoundException;
import com.frkblacksea.customer.exception.MethodNotAllowedException;
import com.frkblacksea.customer.model.ApiResponse;
import com.frkblacksea.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok(this.customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id ) throws CustomerNotFoundException {
        return ResponseEntity.ok(this.customerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> save(@Validated @RequestBody CustomerEntity customerEntity) throws MethodNotAllowedException {
        return new ResponseEntity<>(this.customerService.save(customerEntity), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ApiResponse> update(@Validated @RequestBody CustomerEntity customerEntity) throws MethodNotAllowedException {
        return ResponseEntity.ok(this.customerService.update(customerEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(this.customerService.deleteById(id));
    }
}
