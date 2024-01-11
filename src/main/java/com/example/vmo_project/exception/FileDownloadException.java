package com.example.vmo_project.exception;

public class FileDownloadException extends SpringBootFileUploadException{
  public FileDownloadException(String message) {
    super(message);
  }
}
