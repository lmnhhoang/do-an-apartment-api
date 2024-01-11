package com.example.vmo_project.controller;

import com.example.vmo_project.request.InsertApartmentRequest;
import com.example.vmo_project.request.InsertNewRequest;
import com.example.vmo_project.request.UpdateApartmentRequest;
import com.example.vmo_project.request.UpdateNewRequest;
import com.example.vmo_project.service.NewsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
@SecurityRequirement(name = "Authorization")
public class NewsController {

  @Autowired
  private NewsService newsService;

  @GetMapping("")
  public ResponseEntity<?> getAllNews() {
    return ResponseEntity.ok(newsService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<?> getNewsById(@PathVariable Long id) {
    return ResponseEntity.ok(newsService.getById(id));
  }

  @PostMapping("")
  public ResponseEntity<?> postNews(@RequestBody InsertNewRequest request) {
    return new ResponseEntity<>(newsService.add(request), HttpStatus.CREATED);
  }

  @PutMapping("{id}")
  public ResponseEntity<?> updateNews(@PathVariable Long id,
      @RequestBody UpdateNewRequest request) {
    return ResponseEntity.ok(newsService.update(id, request));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteNews(@PathVariable Long id) {
    newsService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
