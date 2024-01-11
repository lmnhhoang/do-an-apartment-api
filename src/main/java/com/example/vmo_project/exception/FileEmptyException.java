package com.example.vmo_project.exception;

public class FileEmptyException extends SpringBootFileUploadException {
  public FileEmptyException(String message) {
    super(message);
  }
}
