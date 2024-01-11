package com.example.vmo_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
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
@Table(name = "bill")
public class Bill {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @NotNull(message = "electricity number must not be null")
  @Column(name = "electricity_number")
  private Double electricityNumber;

  @NotNull(message = "water number must not be null")
  @Column(name = "water_number")
  private Double waterNumber;

  //    @NotBlank(message = "time of bill must not blank")
  @NotNull(message = "time of bill must not be null")
  @Column(name = "of_month")
  private LocalDate billDate;

  @Column(name = "payment_date")
  private LocalDate paidDate;

  @Column(name = "bill_status")
  private boolean status;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "apartment_id")
  private Apartment apartment;

  @ManyToMany
  @JoinTable(name = "bill_fee_types",
      joinColumns = @JoinColumn(name = "bill_id"),
      inverseJoinColumns = @JoinColumn(name = "feeTypes_id"))
  private List<FeeType> feeTypes = new ArrayList<>();
}
