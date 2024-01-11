package com.example.vmo_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apartments")
public class Apartment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  //    @NotBlank(message = "apartment number must not blank")
  @NotNull(message = "apartment number must not be null")
  @Column(name = "apartment_num", unique = true)
  private String apartmentNumber;

  //    @NotBlank(message = "area must not blank")
  @NotNull(message = "area must not be null")
  @Positive(message = "area must be positive")
  @Column(name = "area")
  private Double area;

  //    @NotBlank(message = "number of room must not blank")
  @NotNull(message = "number of room must not be null")
  @Positive(message = "number of room must be positive")
  @Column(name = "num_rooms")
  private Integer numberOfRooms;

  @Column(name = "apartment_status")
  private boolean status;

  @OneToMany(mappedBy = "apartment")
  private List<Bill> bills = new ArrayList<>();

  @OneToMany(mappedBy = "apartment")
  private List<Person> persons = new ArrayList<>();

  @OneToMany(mappedBy = "apartment")
  private List<Service> services = new ArrayList<>();

  @Override
  public String toString() {
    return "Apartment{" +
        "id=" + id +
        ", apartmentNumber='" + apartmentNumber + '\'' +
        ", area=" + area +
        ", numberOfRooms=" + numberOfRooms +
        ", status=" + status +
        ", bills=" + bills +
        ", persons=" + persons +
        '}';
  }

  @PreRemove
  private void preRemove() {
    for (Bill bill : bills) {
      bill.setApartment(null);
    }
    for (Person person : persons) {
      person.setApartment(null);
    }
  }
}
