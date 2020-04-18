package com.vendor.demo.service;

import com.vendor.demo.model.CustomerEntity;
import com.vendor.demo.model.PassEntity;
import com.vendor.demo.model.PassModel;

import java.util.List;
import java.util.Optional;

public interface PassService {

    PassEntity createPass(PassEntity passEntity);

    Optional<PassEntity> getPass(String pass_id);

    List<PassEntity> getAllPasses();

    PassEntity addPass(PassModel passModel);

    List<PassEntity> getAllValidPasses();

    void cancelPass(String pass_id);

    void deletePass(PassEntity passEntity);

    List<PassEntity> getAllPassesByCustomer(String customer_id);

    Optional<CustomerEntity> getCustomerById(String customer_id);
}
