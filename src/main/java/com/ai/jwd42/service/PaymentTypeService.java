package com.ai.jwd42.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ai.jwd42.dto.PaymentType;
import com.ai.jwd42.repo.PaymentTypeRepo;

@Service
public class PaymentTypeService {
	@Autowired
	
private PaymentTypeRepo paymentTypeRepo;
	
	public boolean addPaymentType(PaymentType PaymentType) {
		boolean status = paymentTypeRepo.addPaymentType(PaymentType);
		if (status) {
			return true;
		}
		return false;
	}
	
	public List<PaymentType> findAll() {
		List<PaymentType> PaymentTypes = paymentTypeRepo.findAll();
		return PaymentTypes;
	}
}
