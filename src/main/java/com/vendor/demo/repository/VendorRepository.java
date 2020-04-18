package com.vendor.demo.repository;


import com.vendor.demo.model.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VendorRepository extends JpaRepository<VendorEntity, String> {

}
