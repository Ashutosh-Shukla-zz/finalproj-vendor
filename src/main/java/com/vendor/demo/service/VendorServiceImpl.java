package com.vendor.demo.service;

import com.vendor.demo.model.VendorEntity;
import com.vendor.demo.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    final
    VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public VendorEntity createVendor(VendorEntity vendorEntity) {
        return vendorRepository.save(vendorEntity);
    }

    @Override
    public Optional<VendorEntity> getVendor(String vendorId) {
        return vendorRepository.findById(vendorId);
    }
}
