package com.example.spring_boot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring_boot.dto.PaymentDto;
import com.example.spring_boot.entity.Payment;
import com.example.spring_boot.service.PaymentService;

@Controller
public class PaymentController {
  private PaymentService paymentService;
  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping("/")
  public ResponseEntity<Payment> createPayment(@RequestBody PaymentDto dto) {
    Payment payment = paymentService.createPayment(dto);


    return new ResponseEntity<Payment>(payment, HttpStatus.OK);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<List<Payment>> getUserPayment(@PathVariable String userId) {
    List<Payment> payments = paymentService.getUserPayment(userId);
    return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
  }
}

// curl -X POST http://localhost:8080/ \
//   -H "Content-Type: application/json" \
//   -d '{
//     "userId": "abc123",
//     "amount": 1500.00,
//     "currency": "THB",
//     "paymentMethod": "credit_card"
//   }'
