package com.vendor.demo.service;

import com.vendor.demo.model.VendorEntity;

import java.util.Optional;

public interface VendorService {

    VendorEntity createVendor(VendorEntity vendorEntity);

    Optional<VendorEntity> getVendor(String vendorId);

}
