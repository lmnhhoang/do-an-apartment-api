package com.example.vmo_project.exception;

public class FileUploadException extends SpringBootFileUploadException{
  public FileUploadException(String message) {
    super(message);
  }
}
