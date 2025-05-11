package com.example.spring_boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.spring_boot.entity.Payment;
import com.example.spring_boot.entity.User;
import com.example.spring_boot.enums.Currency;
import com.example.spring_boot.enums.PaymentMethod;
import com.example.spring_boot.repository.PaymentRepository;
import com.example.spring_boot.repository.UserRepository;

@Configuration
class PreLoadData {

  private static final Logger log = LoggerFactory.getLogger(PreLoadData.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository userRepository, 
  PaymentRepository paymentRepository) {

    return args -> {
      log.info("Preloading " + userRepository.save(new User("gsree", "Gavin", "Sreesangkom", "gavin@gmail.com")));
      log.info("Preloading " + userRepository.save(new User("abx2n", "Aub", "Heng", "abx2n@gmail.com")));
      
      User gavin = userRepository.findByUsername("gsree");

      log.info("Preloading " + paymentRepository.save(new Payment(gavin, 120.00, Currency.THB, PaymentMethod.CREDIT_CARD)));
      log.info("Preloading " + paymentRepository.save(new Payment(gavin, 1600.00, Currency.THB, PaymentMethod.CREDIT_CARD)));
      log.info("Preloading " + paymentRepository.save(new Payment(gavin, 10.00, Currency.THB, PaymentMethod.CREDIT_CARD)));
      log.info("Preloading " + paymentRepository.save(new Payment(gavin, 120.00, Currency.THB, PaymentMethod.WIRE)));
      log.info("Preloading " + paymentRepository.save(new Payment(gavin, 50.00, Currency.USD, PaymentMethod.CREDIT_CARD)));
    };
  }
}
