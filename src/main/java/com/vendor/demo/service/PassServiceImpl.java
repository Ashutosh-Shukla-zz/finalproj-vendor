package com.vendor.demo.service;

import com.vendor.demo.model.CustomerEntity;
import com.vendor.demo.model.PassEntity;
import com.vendor.demo.model.PassModel;
import com.vendor.demo.repository.CustomerRepository;
import com.vendor.demo.repository.PassRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PassServiceImpl implements PassService {

    final
    PassRepository passRepository;

    final CustomerRepository customerRepository;

    public PassServiceImpl(PassRepository passRepository, CustomerRepository customerRepository) {
        this.passRepository = passRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public PassEntity createPass(PassEntity passEntity) {
        return passRepository.save(passEntity);
    }

    @Override
    public Optional<PassEntity> getPass(String pass_id) {
        return passRepository.findById(pass_id);
    }

    @Override
    public List<PassEntity> getAllPasses() {
        return passRepository.findAll();
    }

    @Override
    public PassEntity addPass(PassModel passModel) {
        Optional<PassEntity> passEntity = passRepository.findById(passModel.getPass_id());
        if (passEntity.isPresent()) {
            PassEntity pass = passEntity.get();
            if (pass.getExpiry_date().compareTo(new Date()) > 0 && pass.getCustomer() == null) {
                Optional<CustomerEntity> cust = getCustomerById(passModel.getCustomer_id());
                CustomerEntity customerEntity;
                if (cust.isPresent()) {
                    customerEntity = cust.get();
                    pass.setCustomer(customerEntity);
                    passRepository.save(pass);
                    return pass;
                }
            }
        }
        return null;
    }

    @Override
    public List<PassEntity> getAllValidPasses() {
        return passRepository.finaAllValidPasses();
    }

    @Override
    public void cancelPass(String pass_id) {
        passRepository.cancelPass(pass_id);
    }

    @Override
    public void deletePass(PassEntity passEntity) {
        passRepository.delete(passEntity);
    }

    @Override
    public List<PassEntity> getAllPassesByCustomer(String customer_id) {
        return passRepository.findAllByCustomerId(customer_id);
    }

    @Override
    public Optional<CustomerEntity> getCustomerById(String customer_id) {
        return customerRepository.findById(customer_id);
    }
}
