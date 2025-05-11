package com.example.spring_boot.entity;

import java.time.LocalDateTime;

import com.example.spring_boot.enums.Currency;
import com.example.spring_boot.enums.PaymentMethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(nullable = false)
  private User user;

  private Double amount;

  private Currency currency;

  private PaymentMethod paymentMethod;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  public Payment() {

  }

  public Payment(
    User user,
    Double amount,
    Currency currency,
    PaymentMethod paymentMethod
  ) {
    this.user = user;
    this.amount = amount;
    this.currency = currency;
    this.paymentMethod = paymentMethod;
  }

  // Getters and Setters

  public Long getId() {
      return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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
