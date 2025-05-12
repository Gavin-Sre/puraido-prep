package com.example.spring_boot.processor;

import org.springframework.stereotype.Component;

import com.example.spring_boot.enums.PaymentMethod;

@Component
public class PaymentProcessorFactory {
  private final CreditCardProcessor creditCardProcessor;
  private final OnlineBankingProcessor onlineBankingProcessor;

  public PaymentProcessorFactory(
    CreditCardProcessor creditCardProcessor,
    OnlineBankingProcessor onlineBankingProcessor
  ) {
    this.creditCardProcessor = creditCardProcessor;
    this.onlineBankingProcessor = onlineBankingProcessor;
  }

  public PaymentProcessor getProcessor(PaymentMethod paymentMethod) {
    return switch (paymentMethod) {
      case CREDIT_CARD -> creditCardProcessor;
      case WIRE -> onlineBankingProcessor;
      default -> throw new IllegalArgumentException("Unsupported payment method: " + paymentMethod);
    };
  }
}

