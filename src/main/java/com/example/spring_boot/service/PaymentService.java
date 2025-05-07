package com.example.spring_boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring_boot.dto.PaymentDto;
import com.example.spring_boot.entity.Payment;
import com.example.spring_boot.repository.PaymentRepository;

@Service
public class PaymentService {
  private PaymentRepository paymentRepository;

  public PaymentService(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  public Payment createPayment(PaymentDto dto) {
    Payment payment = new Payment();
    payment.setAmount(dto.getAmount());
    payment.setCurrency(dto.getCurrency());
    payment.setUserId(dto.getUserId());
    payment.setPaymentMethod(dto.getPaymentMethod());

    return paymentRepository.save(payment);
  }

  public List<Payment> getUserPayment(String userId) {
    return paymentRepository.findByUserId(userId);
  }
}
