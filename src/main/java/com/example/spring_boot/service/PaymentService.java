package com.example.spring_boot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.spring_boot.dto.PaymentDto;
import com.example.spring_boot.entity.Payment;
import com.example.spring_boot.entity.User;
import com.example.spring_boot.repository.PaymentRepository;
import com.example.spring_boot.repository.UserRepository;

@Service
public class PaymentService {
  private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

  private PaymentRepository paymentRepository;
  private UserRepository userRepository;

  public PaymentService(
    PaymentRepository paymentRepository,
    UserRepository userRepository
    ) {
    this.paymentRepository = paymentRepository;
    this.userRepository = userRepository;
  }

  public Payment createPayment(PaymentDto dto) {
    Payment payment = new Payment();
    payment.setAmount(dto.getAmount());
    payment.setCurrency(dto.getCurrency());
    // Get user from username
    try {
      User user = userRepository.findByUsername(dto.getUsername());
      if (user == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
      }
      payment.setUser(user);
    } catch(Error error) {
      log.info(error.getMessage());
    }
    
    payment.setPaymentMethod(dto.getPaymentMethod());

    return paymentRepository.save(payment);
  }

  public List<Payment> getUserPayment(String username) {
    User user = userRepository.findByUsername(username);
    return paymentRepository.findByUser(user);
  }
}
