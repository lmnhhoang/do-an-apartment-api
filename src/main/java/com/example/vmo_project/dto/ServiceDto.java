package com.example.vmo_project.dto;

import com.example.vmo_project.entity.Apartment;
import com.example.vmo_project.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {

  private Long id;
  private int type;
  private String message;
  private int status;
  private Apartment apartment;

  public ServiceDto(Service entity) {
    this.setId(entity.getId());
    this.type = entity.getType();
    this.message = entity.getMessage();
    this.status = entity.getStatus();
    this.apartment = entity.getApartment();
  }
}
