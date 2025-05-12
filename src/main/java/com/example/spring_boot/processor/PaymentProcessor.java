package com.example.spring_boot.processor;

import com.example.spring_boot.entity.Payment;

public interface PaymentProcessor {
  public PaymentResult processPayment(Payment payment);
  public PaymentResult processRefund(Payment payment);
}