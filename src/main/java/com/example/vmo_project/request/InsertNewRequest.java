package com.example.vmo_project.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsertNewRequest {
  private String title;
  private int type;
  private String message;
  private String img_url;
}
