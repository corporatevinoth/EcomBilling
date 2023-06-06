package com.ecommerce.billing.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.billing.model.Bill;
import com.ecommerce.billing.repository.BillingRepository;

@Service
public class BillingService {
	 @Autowired
	    private BillingRepository billingRepository;
	 
	    // Save operation
	    
	    public Bill saveBill(Bill bill)
	    {
	        return billingRepository.save(bill);
	    }
	 
	    // Read operation
	     public List<Bill> fetchBillList()
	    {
	        return (List<Bill>)
	            billingRepository.findAll();
	    }
	 
	    // Update operation
	    public Bill
	    updateBill(Bill bill,
	                     Long billNo)
	    {
	 
	        Bill depDB
	            = billingRepository.findById(billNo)
	                  .get();
	 
	        if (Objects.nonNull(bill.getProductName())
	            && !"".equalsIgnoreCase(
	                bill.getProductName())) {
	            depDB.setProductName(
	                bill.getProductName());
	        }
	 
	        if (Objects.nonNull(
	                bill.getDescription())
	            && !"".equalsIgnoreCase(
	                bill.getDescription())) {
	            depDB.setDescription(
	                bill.getDescription());
	        }
	 
	        if (Objects.nonNull(bill.getBatchNo())
	            && !"".equalsIgnoreCase(
	                bill.getBatchNo())) {
	            depDB.setBatchNo(
	                bill.getBatchNo());
	        }
	 
	        return billingRepository.save(depDB);
	    }
	 
	    // Delete operation
	    public void deleteBillById(Long billNo)
	    {
	        billingRepository.deleteById(billNo);
	    }
}
