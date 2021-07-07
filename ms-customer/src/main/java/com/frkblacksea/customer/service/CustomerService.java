package com.frkblacksea.customer.service;

import com.frkblacksea.customer.domain.CustomerEntity;
import com.frkblacksea.customer.exception.CustomerNotFoundException;
import com.frkblacksea.customer.exception.MethodNotAllowedException;
import com.frkblacksea.customer.model.ApiResponse;

import java.util.List;

public interface CustomerService {
    ApiResponse getAll();
    ApiResponse getById(Long id) throws CustomerNotFoundException;
    ApiResponse save(CustomerEntity customerEntity) throws MethodNotAllowedException;
    ApiResponse update(CustomerEntity customerEntity) throws MethodNotAllowedException;
    ApiResponse deleteById(Long id);
}
