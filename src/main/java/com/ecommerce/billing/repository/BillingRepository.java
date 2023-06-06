package com.ecommerce.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.billing.model.Bill;

@Repository
public interface BillingRepository extends JpaRepository<Bill,Long> {

	
 }
