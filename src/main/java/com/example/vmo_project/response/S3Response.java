package com.example.vmo_project.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class S3Response {
  private String message;
  private boolean isSuccessful;
  private int statusCode;
  private Object data;
}
