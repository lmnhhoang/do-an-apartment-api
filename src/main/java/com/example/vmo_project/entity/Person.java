package com.example.vmo_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
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
@Table(name = "person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @NotNull(message = "person name must not be null")
//    @NotBlank(message = "person name must not blank")
  @Column(name = "name")
  private String name;

  @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "invalid email address")
  @Column(name = "email", unique = true)
  private String email;

  //    @Digits(integer = 11, fraction = 0, message= "invalid phone number")
  @Size(min = 9, max = 18, message = "the length of phone number is invalid")
  @Column(name = "phone_number", unique = true)
  private String phoneNumber;

  //    @Digits(integer = 11, fraction = 0, message= "invalid card id number")
  @Column(name = "cardID_number", unique = true)
  private String cardIdNumber;

  @NotNull(message = "birth date must not be null")
  @Column(name = "birth_date")
  private LocalDate birthDate;

  @NotNull(message = "gender must not be null")
  @Column(name = "gender")
  private boolean gender;

  @Column(name = "representative")
  private boolean representative;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "apartment_id")
  private Apartment apartment;
}
