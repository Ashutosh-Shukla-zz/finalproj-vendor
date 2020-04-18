package com.vendor.demo.repository;

import com.vendor.demo.model.PassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PassRepository extends JpaRepository<PassEntity, String> {

    @Modifying
    @Query(value = "UPDATE pass p SET p.customer_id = ?1 where p.pass_id = ?2", nativeQuery = true)
    void addPass(String customer_id, String pass_id);

    @Query(value = "SELECT * FROM pass p WHERE p.customer_id IS NULL and p.expiry_date > now()", nativeQuery = true)
    List<PassEntity> finaAllValidPasses();

    @Modifying
    @Query(value = "UPDATE pass p SET p.customer_id = NULL where p.pass_id = ?1", nativeQuery = true)
    void cancelPass(String pass_id);

    @Query(value = "SELECT * FROM pass p WHERE p.customer_id = ?1", nativeQuery = true)
    List<PassEntity> findAllByCustomerId(String customer_id);
}
