package com.example.spring_boot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_boot.dto.PaymentDto;
import com.example.spring_boot.entity.Payment;
import com.example.spring_boot.service.PaymentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/payments")
public class PaymentController {
  private PaymentService paymentService;
  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping("")
  public ResponseEntity<Payment> createPayment(@Valid @RequestBody PaymentDto dto) {
    Payment payment = paymentService.createPayment(dto);


    return new ResponseEntity<Payment>(payment, HttpStatus.OK);
  }

  @GetMapping("/{userId}")
  public String getUserPayment(@PathVariable String userId, Model model) {
    List<Payment> payments = paymentService.getUserPayment(userId);
    model.addAttribute("payments", payments);
    return "payments"; // This resolves to templates/payments.html
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
