package com.example.spring_boot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_boot.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

  public List<Payment> findByUserId(String userId);

  // Native SQL query to find students by email
  //   @Query(value = "SELECT * FROM students WHERE email = :email", nativeQuery = true)
  //   Student findStudentByEmail(@Param("email") String email);

  // JPQL query to find students by name
  // @Query("SELECT s FROM Student s WHERE s.name = :name")
  // List<Student> findStudentsByName(@Param("name") String name);
}
