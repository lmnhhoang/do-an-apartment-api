package com.example.vmo_project.controller;

import com.example.vmo_project.request.InsertNewRequest;
import com.example.vmo_project.request.InsertServiceRequest;
import com.example.vmo_project.request.UpdateNewRequest;
import com.example.vmo_project.request.UpdateServiceRequest;
import com.example.vmo_project.service.ServiceService;
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
@RequestMapping("/api/services")
@SecurityRequirement(name = "Authorization")
public class ServiceController {

  @Autowired
  private ServiceService serviceService;

  @GetMapping("")
  public ResponseEntity<?> getAllServices() {
    return ResponseEntity.ok(serviceService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<?> getServiceById(@PathVariable Long id) {
    return ResponseEntity.ok(serviceService.getById(id));
  }

  @PostMapping("")
  public ResponseEntity<?> postService(@RequestBody InsertServiceRequest request) {
    return new ResponseEntity<>(serviceService.add(request), HttpStatus.CREATED);
  }

  @PutMapping("{id}")
  public ResponseEntity<?> updateService(@PathVariable Long id,
      @RequestBody UpdateServiceRequest request) {
    return ResponseEntity.ok(serviceService.update(id, request));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteService(@PathVariable Long id) {
    serviceService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
