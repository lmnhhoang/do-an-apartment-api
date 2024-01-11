package com.example.vmo_project.dto;

import com.example.vmo_project.entity.Apartment;
import com.example.vmo_project.entity.Person;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

  private Long id;
  private String name;
  private String email;
  private String phoneNumber;
  private String cardIdNumber;
  private LocalDate birthDate;
  private boolean gender;
  private boolean representative;
  private Apartment apartment;

  public PersonDto(Person entity) {
    this.setId(entity.getId());
    this.name = entity.getName();
    this.email = entity.getEmail();
    this.phoneNumber = entity.getPhoneNumber();
    this.cardIdNumber = entity.getCardIdNumber();
    this.birthDate = entity.getBirthDate();
    this.gender = entity.isGender();
    this.representative = entity.isRepresentative();
    if (entity.getApartment() == null) {
      this.apartment = null;
    } else {
      this.apartment = entity.getApartment();
    }
  }
}
