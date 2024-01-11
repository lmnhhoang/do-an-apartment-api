package com.example.vmo_project.service;

import com.example.vmo_project.constant.ConstantError;
import com.example.vmo_project.dto.ApartmentDto;
import com.example.vmo_project.dto.DeviceDto;
import com.example.vmo_project.entity.Apartment;
import com.example.vmo_project.entity.Device;
import com.example.vmo_project.entity.Person;
import com.example.vmo_project.exception.NotFoundException;
import com.example.vmo_project.repository.DeviceRepository;
import com.example.vmo_project.request.InsertApartmentRequest;
import com.example.vmo_project.request.InsertDeviceRequest;
import com.example.vmo_project.request.UpdateApartmentRequest;
import com.example.vmo_project.request.UpdateDeviceRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {
  private final DeviceRepository deviceRepository;
  // Lấy danh sách tất cả thiet bi
  public List<DeviceDto> getAll() {
    return deviceRepository.findAll()
        .stream()
        .map(DeviceDto::new)
        .toList();
  }

  public DeviceDto getById(Long id) {
    return new DeviceDto(deviceRepository.findById(id).orElseThrow(() -> {
      throw new NotFoundException(ConstantError.DEVICE_NOT_FOUND + id);
    }));
  }

  public DeviceDto add(InsertDeviceRequest request) {
    Device device = Device.builder()
        .name(request.getName())
        .price(request.getPrice())
        .descr(request.getDescr())
        .status(request.getStatus())
        .last_updated(new Date())
        .build();
    deviceRepository.save(device);
    return new DeviceDto(device);
  }

  public DeviceDto update(Long id, UpdateDeviceRequest request) {
    Device device = deviceRepository.findById(id).orElseThrow(() -> {
      throw new NotFoundException(ConstantError.DEVICE_NOT_FOUND + id);
    });
    device.setStatus(request.getStatus());
    device.setLast_updated(request.getLast_updated());

    deviceRepository.save(device);
    return new DeviceDto(device);
  }

  public void delete(Long id) {
    Device device = deviceRepository.findById(id).orElseThrow(() -> {
      throw new NotFoundException(ConstantError.DEVICE_NOT_FOUND + id);
    });
    deviceRepository.delete(device);
  }
}
