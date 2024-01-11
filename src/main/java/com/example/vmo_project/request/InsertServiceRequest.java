package com.example.vmo_project.request;

import com.example.vmo_project.entity.Apartment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsertServiceRequest {
  private int type;
  private String message;
  private int status;
  private Long apartmentId;
}
