package com.example.vmo_project.dto;

import com.example.vmo_project.entity.Apartment;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentDto {

  private Long id;
  private String apartmentNumber;
  private Double area;
  private Integer numberOfRooms;
  private boolean status;
  private List<BillDto> bills = new ArrayList<>();
  private List<PersonDto> persons = new ArrayList<>();
  private List<ServiceDto> services = new ArrayList<>();

  public ApartmentDto(Apartment entity) {
    this.setId(entity.getId());
    this.apartmentNumber = entity.getApartmentNumber();
    this.area = entity.getArea();
    this.numberOfRooms = entity.getNumberOfRooms();
    this.status = entity.isStatus();
    this.bills = entity.getBills().stream().map(BillDto::new).toList();
    this.persons = entity.getPersons().stream().map(PersonDto::new).toList();
    this.services = entity.getServices().stream().map(ServiceDto::new).toList();
  }
}
