package com.example.spring_boot.entity;

import java.time.LocalDateTime;

import com.example.spring_boot.enums.Currency;
import com.example.spring_boot.enums.PaymentMethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private Long id;

  private String username;

  private Double amount;

  private Currency currency;

  private PaymentMethod paymentMethod;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  // Getters and Setters

  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

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

  public LocalDateTime getCreatedAt() {
      return createdAt;
  }
}
