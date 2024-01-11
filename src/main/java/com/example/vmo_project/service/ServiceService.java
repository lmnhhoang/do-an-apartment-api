package com.example.vmo_project.service;

import com.example.vmo_project.constant.ConstantDateFormat;
import com.example.vmo_project.constant.ConstantError;
import com.example.vmo_project.dto.BillDto;
import com.example.vmo_project.dto.ServiceDto;
import com.example.vmo_project.entity.Bill;
import com.example.vmo_project.exception.NotFoundException;
import com.example.vmo_project.repository.ApartmentRepository;
import com.example.vmo_project.repository.BillRepository;
import com.example.vmo_project.repository.ServiceRepository;
import com.example.vmo_project.request.InsertBillRequest;
import com.example.vmo_project.request.InsertServiceRequest;
import com.example.vmo_project.request.UpdateBillRequest;
import com.example.vmo_project.request.UpdateServiceRequest;
import java.time.LocalDate;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceService {
  private final ServiceRepository serviceRepository;
  private final ApartmentRepository apartmentRepository;

  public List<ServiceDto> getAll() {
    return serviceRepository.findAll().stream()
        .map(ServiceDto::new)
        .toList();
  }

  public ServiceDto getById(Long id) {
    return new ServiceDto(serviceRepository.findById(id).orElseThrow(() -> {
      throw new NotFoundException(ConstantError.SERVICE_NOT_FOUND + id);
    }));
  }

  public List<ServiceDto> getByApartmentId(Long apartmentId) {
    return serviceRepository.findAllByApartmentId(apartmentId)
        .stream()
        .map(ServiceDto::new)
        .toList();
  }
  public ServiceDto add(InsertServiceRequest request) {
    com.example.vmo_project.entity.Service service = com.example.vmo_project.entity.Service.builder()
        .type(request.getType())
        .message(request.getMessage())
        .status(request.getStatus())
        .apartment(apartmentRepository.findById(request.getApartmentId()).orElseThrow(() -> {
          throw new NotFoundException(ConstantError.APARTMENT_NOT_FOUND + request.getApartmentId());
        }))
        .build();
    serviceRepository.save(service);
    return new ServiceDto(service);
  }
  public ServiceDto update(Long id, UpdateServiceRequest request) {
    com.example.vmo_project.entity.Service service = serviceRepository.findById(id).orElseThrow(() -> {
      throw new NotFoundException(ConstantError.SERVICE_NOT_FOUND + id);
    });
    service.setStatus(request.getStatus());
    serviceRepository.save(service);
    return new ServiceDto(service);
  }
  public void delete(Long id) {
    com.example.vmo_project.entity.Service service = serviceRepository.findById(id).orElseThrow(() -> {
      throw new NotFoundException(ConstantError.SERVICE_NOT_FOUND + id);
    });
    serviceRepository.delete(service);
  }
}
