package com.example.vmo_project.dto;

import com.example.vmo_project.entity.Device;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {

  private Long id;
  private String name;
  private Double price;
  private String descr;
  private int status;
  private Date last_updated;

  public DeviceDto(Device entity) {
    this.setId(entity.getId());
    this.name = entity.getName();
    this.price = entity.getPrice();
    this.descr = entity.getDescr();
    this.status = entity.getStatus();
    this.last_updated = entity.getLast_updated();
  }
}
