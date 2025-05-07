package com.example.spring_boot.dto;

import java.time.LocalDateTime;

import com.example.spring_boot.enums.Currency;
import com.example.spring_boot.enums.PaymentMethod;

import jakarta.persistence.Column;

public class PaymentDto {
  private String message;

  private String username;

  private Double amount;

  private Currency currency;

  private PaymentMethod paymentMethod;

  public PaymentDto() {
  }

  public PaymentDto(Double amount, String message) {
    this.amount = amount;
    this.message = message;
  }

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  // Getters and Setters

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Double getAmount() {
      return amount;
  }

  public void setAmount(Double amount) {
      this.amount = amount;
  }

  public Currency getCurrency() {
    return currency;
}

  public void setCurrency(Currency currency) {
      this.currency = currency;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  // toString
  @Override
  public String toString() {
      return "PaymentDto{" +
              "amount=" + amount +
              ", message='" + message + '\'' +
              '}';
  }
}
