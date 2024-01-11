package com.example.vmo_project.service;

import com.example.vmo_project.exception.FileDownloadException;
import com.example.vmo_project.exception.FileUploadException;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
  String uploadFile(MultipartFile multipartFile) throws FileUploadException, IOException;

  Object downloadFile(String fileName) throws FileDownloadException, IOException;

  boolean delete(String fileName);
}
