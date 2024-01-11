package com.example.vmo_project.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsertBillRequest {

  private Double electricityNumber;
  private Double waterNumber;
  private String billDate;
  private Long apartmentId;
  private List<Long> feeTypeId;
}
