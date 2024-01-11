package com.example.vmo_project.controller;

import com.example.vmo_project.request.InsertDeviceRequest;
import com.example.vmo_project.request.InsertNewRequest;
import com.example.vmo_project.request.UpdateDeviceRequest;
import com.example.vmo_project.request.UpdateNewRequest;
import com.example.vmo_project.service.DeviceService;
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
@RequestMapping("/api/devices")
@SecurityRequirement(name = "Authorization")
public class DeviceController {

  @Autowired
  private DeviceService deviceService;

  @GetMapping("")
  public ResponseEntity<?> getAllDevices() {
    return ResponseEntity.ok(deviceService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<?> getDeviceById(@PathVariable Long id) {
    return ResponseEntity.ok(deviceService.getById(id));
  }

  @PostMapping("")
  public ResponseEntity<?> postDevice(@RequestBody InsertDeviceRequest request) {
    return new ResponseEntity<>(deviceService.add(request), HttpStatus.CREATED);
  }

  @PutMapping("{id}")
  public ResponseEntity<?> updateDevice(@PathVariable Long id,
      @RequestBody UpdateDeviceRequest request) {
    return ResponseEntity.ok(deviceService.update(id, request));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteDevice(@PathVariable Long id) {
    deviceService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
