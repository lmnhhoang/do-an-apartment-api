package com.example.vmo_project.controller;

import com.example.vmo_project.entity.User;
import com.example.vmo_project.repository.UserRepository;
import com.example.vmo_project.request.InsertNewRequest;
import com.example.vmo_project.request.InsertUserRequest;
import com.example.vmo_project.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@SecurityRequirement(name = "Authorization")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserService userService;

  @PostMapping("")
  public ResponseEntity<?> initUser() {
    User user = User.builder()
        .username("admin")
        .password(passwordEncoder.encode("admin"))
        .build();
    userRepository.save(user);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }
  @GetMapping("")
  public ResponseEntity<?> getAllUsers() {
    return ResponseEntity.ok(userService.getAll());
  }

  @PostMapping("/create")
  public ResponseEntity<?> postUser(@RequestBody InsertUserRequest request) {
    return new ResponseEntity<>(userService.add(request), HttpStatus.CREATED);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteNews(@PathVariable Long id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
