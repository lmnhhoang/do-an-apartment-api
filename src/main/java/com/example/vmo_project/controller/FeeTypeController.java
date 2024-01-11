package com.example.vmo_project.controller;

import com.example.vmo_project.request.UpdateFeePriceRequest;
import com.example.vmo_project.service.FeeTypeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fees")
@SecurityRequirement(name = "Authorization")
public class FeeTypeController {

  @Autowired
  private FeeTypeService feeTypeService;

  @GetMapping("")
  public ResponseEntity<?> getAllFees() {
    return ResponseEntity.ok(feeTypeService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<?> getFeeById(@PathVariable Long id) {
    return ResponseEntity.ok(feeTypeService.getById(id));
  }

  @PutMapping("{id}")
  public ResponseEntity<?> updateFeePrice(@PathVariable Long id,
      @RequestBody UpdateFeePriceRequest request) {
    return ResponseEntity.ok(feeTypeService.update(id, request));
  }
}
