package com.example.spring_boot.repository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import com.example.spring_boot.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  public User findByUsername(String username);
}
