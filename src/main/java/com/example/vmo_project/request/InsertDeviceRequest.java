package com.example.vmo_project.request;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsertDeviceRequest {
  private String name;
  private Double price;
  private String descr;
  private int status;
  private Date last_updated;
}
