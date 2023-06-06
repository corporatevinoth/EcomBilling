package com.ecommerce.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.billing.model.Bill;
import com.ecommerce.billing.service.BillingService;

import jakarta.validation.Valid;

@RestController
public class BillingController {

	@Autowired
	private BillingService billingService;

	// Save operation
	@PostMapping("/bills")
	public Bill saveBill(@Valid @RequestBody Bill bill) {
		return billingService.saveBill(bill);
	}

	// Read operation
	@GetMapping("/bills")
	public List<Bill> fetchBillList() {
		return billingService.fetchBillList();
	}

	// Update operation
	@PutMapping("/bills/{id}")
	public Bill updateBill(@RequestBody Bill bill, @PathVariable("id") Long inventoryId) {
		return billingService.updateBill(bill, inventoryId);
	}

	// Delete operation
	@DeleteMapping("/bills/{id}")
	public String deleteBillById(@PathVariable("id") Long inventoryId) {
		billingService.deleteBillById(inventoryId);
		return "Deleted Successfully";
	}
}
