package com.example.spring_boot.processor;

import org.springframework.stereotype.Component;

import com.example.spring_boot.entity.Payment;
import com.example.spring_boot.enums.PaymentMethod;
import com.example.spring_boot.enums.ProcessType;

@Component
public class OnlineBankingProcessor implements PaymentProcessor {
  @Override
  public PaymentResult processPayment(Payment payment) {
    if (payment.getPaymentMethod() != PaymentMethod.WIRE) {
      throw new IllegalArgumentException("Invalid payment method");
    }
    PaymentResult result = new PaymentResult(true, ProcessType.PAYMENT);
    return result;
  }

  @Override
  public PaymentResult processRefund(Payment payment) {
    if (payment.getPaymentMethod() != PaymentMethod.WIRE) {
      throw new IllegalArgumentException("Invalid payment method");
    }
    PaymentResult result = new PaymentResult(true, ProcessType.REFUND);
    return result;
  }
}
