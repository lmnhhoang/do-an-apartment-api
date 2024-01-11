package com.example.vmo_project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "fee_type")
public class FeeType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  //    @NotBlank(message = "fee type must not blank")
  @NotNull(message = "fee type must not be null")
  @Column(name = "type", unique = true)
  private String name;

  //    @NotBlank(message = "fee price must not blank")
  @NotNull(message = "fee price must not be null")
  @Column(name = "price")
  private Double price;

  @JsonBackReference
  @ManyToMany(mappedBy = "feeTypes")
  private List<Bill> bills;
}
