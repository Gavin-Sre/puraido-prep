package com.example.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_boot.entity.User;
import com.example.spring_boot.repository.UserRepository;

@Controller
@RequestMapping("/")
public class UserController {

  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping
  public String getAllUsers(Model model) {
    Iterable<User> allUsers = userRepository.findAll();
    model.addAttribute("users", allUsers);
    return "index"; // Refers to index.html in /templates
  }
  
}
