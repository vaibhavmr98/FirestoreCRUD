package com.example.firebasedemo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.firebasedemo.pojo.SalesVo;
import com.example.firebasedemo.service.FirebaseCustomService;

@RestController
public class FirebaseController {

	@Autowired
	FirebaseCustomService firebaseCustomService;

	@PostMapping("/createSales")
	public String createSales(@RequestBody SalesVo salesVo) throws InterruptedException, ExecutionException {
		return firebaseCustomService.saveSalesDetails(salesVo);
	}

	@GetMapping("/getSalesDetails")
	public SalesVo getSales(@RequestParam long salesId) throws InterruptedException, ExecutionException {
		return firebaseCustomService.getSalesDetails(salesId);
	}

	@PutMapping("/updateSales")
	public String updateSalesVo(@RequestBody SalesVo salesVo) throws InterruptedException, ExecutionException {
		return firebaseCustomService.updateSalesDetails(salesVo);
	}

	@DeleteMapping("/deleteSales")
	public String deleteSales(@RequestParam long salesId) {
		return firebaseCustomService.deleteSales(salesId);
	}
}
