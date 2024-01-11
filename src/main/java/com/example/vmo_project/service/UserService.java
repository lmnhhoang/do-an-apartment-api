package com.example.vmo_project.service;

import com.example.vmo_project.constant.ConstantError;
import com.example.vmo_project.dto.NewsDto;
import com.example.vmo_project.dto.UserDto;
import com.example.vmo_project.entity.News;
import com.example.vmo_project.entity.User;
import com.example.vmo_project.exception.NotFoundException;
import com.example.vmo_project.repository.UserRepository;
import com.example.vmo_project.request.InsertNewRequest;
import com.example.vmo_project.request.InsertUserRequest;
import com.example.vmo_project.request.UpdateNewRequest;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  public List<UserDto> getAll() {
    return userRepository.findAll()
        .stream()
        .map(UserDto::new)
        .toList();
  }

  public UserDto getById(Long id) {
    return new UserDto(userRepository.findById(id).orElseThrow(() -> {
      throw new NotFoundException(ConstantError.NEWS_NOT_FOUND + id);
    }));
  }

  public UserDto add(InsertUserRequest request) {
    User user = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .build();
    userRepository.save(user);
    return new UserDto(user);
  }

  public void delete(Long id) {
    User user = userRepository.findById(id).orElseThrow(() -> {
      throw new NotFoundException(ConstantError.NEWS_NOT_FOUND + id);
    });
    userRepository.delete(user);
  }
}
