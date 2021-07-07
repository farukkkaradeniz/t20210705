package com.frkblacksea.customer.service.impl;

import com.frkblacksea.customer.domain.CustomerEntity;
import com.frkblacksea.customer.exception.CustomerNotFoundException;
import com.frkblacksea.customer.exception.MethodNotAllowedException;
import com.frkblacksea.customer.model.ApiResponse;
import com.frkblacksea.customer.repository.CustomerRepository;
import com.frkblacksea.customer.service.CustomerService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse.ApiResponseBuilder()
                .setStatusCode(200)
                .setMessage("Success")
                .setBody(customerRepository.findAll())
                .build();
    }

    @Override
    public ApiResponse getById(Long id) throws CustomerNotFoundException {
        return new ApiResponse.ApiResponseBuilder()
                .setStatusCode(200)
                .setMessage("Success")
                .setBody(customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Verilen " + id + " bilgisiyle müşteri bulunamadı")))
                .build();
    }

    @Override
    public ApiResponse save(CustomerEntity customerEntity) throws MethodNotAllowedException {
        if (customerEntity.getId() != null) {
            throw new MethodNotAllowedException("Müşteri kayıt işleminde id gönderemezsiniz!!!");
        }
        return new ApiResponse.ApiResponseBuilder()
                .setStatusCode(201)
                .setMessage("Success")
                .setBody(this.customerRepository.save(customerEntity))
                .build();
    }

    @Override
    public ApiResponse update(CustomerEntity customerEntity) throws MethodNotAllowedException {
        if (customerEntity.getId() == null) {
            throw new MethodNotAllowedException("Müşteri kayıt işleminde id göndermelisiniz !!!");
        }
        return new ApiResponse.ApiResponseBuilder()
                .setStatusCode(200)
                .setMessage("Success")
                .setBody(this.customerRepository.save(customerEntity))
                .build();
    }

    @Override
    public ApiResponse deleteById(Long id) {
        this.customerRepository.deleteById(id);
        return new ApiResponse.ApiResponseBuilder()
                .setStatusCode(200)
                .setMessage(id + "'li Müşteri bilgisi silindi")
                .setBody(null)
                .build();
    }
}
