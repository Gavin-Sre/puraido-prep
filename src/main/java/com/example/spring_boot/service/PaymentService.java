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
import com.example.spring_boot.processor.PaymentProcessor;
import com.example.spring_boot.processor.PaymentProcessorFactory;
import com.example.spring_boot.processor.PaymentResult;
import com.example.spring_boot.repository.PaymentRepository;
import com.example.spring_boot.repository.UserRepository;

@Service
public class PaymentService {
  private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
  
  private final PaymentProcessorFactory processorFactory;
  private PaymentRepository paymentRepository;
  private UserRepository userRepository;

  public PaymentService(
    PaymentRepository paymentRepository,
    UserRepository userRepository,
    PaymentProcessorFactory processorFactory
    ) {
    this.paymentRepository = paymentRepository;
    this.userRepository = userRepository;
    this.processorFactory = processorFactory;
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

    
    // Prcess payment
    PaymentProcessor processor = processorFactory.getProcessor(dto.getPaymentMethod());
    PaymentResult result = processor.processPayment(payment);
    if (result.isSuccess()) {
      return paymentRepository.save(payment);
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Payment processing failed");
    }    
  }

  public List<Payment> getUserPayment(String username) {
    User user = userRepository.findByUsername(username);
    return paymentRepository.findByUser(user);
  }
}
