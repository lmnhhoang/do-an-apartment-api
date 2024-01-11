package com.example.vmo_project.dto;

import com.example.vmo_project.entity.News;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {

  private Long id;
  private String title;
  private int type;
  private String message;

  public NewsDto(News entity) {
    this.setId(entity.getId());
    this.title = entity.getTitle();
    this.type = entity.getType();
    this.message = entity.getContent();
  }
}
