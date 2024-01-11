package com.example.vmo_project.service;

import com.example.vmo_project.constant.ConstantError;
import com.example.vmo_project.dto.DeviceDto;
import com.example.vmo_project.dto.NewsDto;
import com.example.vmo_project.entity.Device;
import com.example.vmo_project.entity.News;
import com.example.vmo_project.exception.NotFoundException;
import com.example.vmo_project.repository.NewsRepository;
import com.example.vmo_project.request.InsertDeviceRequest;
import com.example.vmo_project.request.InsertNewRequest;
import com.example.vmo_project.request.UpdateDeviceRequest;
import com.example.vmo_project.request.UpdateNewRequest;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsService {
  private final NewsRepository newsRepository;

  public List<NewsDto> getAll() {
    return newsRepository.findAll()
        .stream()
        .map(NewsDto::new)
        .toList();
  }

  public NewsDto getById(Long id) {
    return new NewsDto(newsRepository.findById(id).orElseThrow(() -> {
      throw new NotFoundException(ConstantError.NEWS_NOT_FOUND + id);
    }));
  }

  public NewsDto add(InsertNewRequest request) {
    News news = News.builder()
        .title(request.getTitle())
        .type(request.getType())
        .content(request.getMessage())
        .img_url(request.getImg_url())
        .created_date(new Date().toString())
        .build();
    newsRepository.save(news);
    return new NewsDto(news);
  }

  public NewsDto update(Long id, UpdateNewRequest request) {
    News news = newsRepository.findById(id).orElseThrow(() -> {
      throw new NotFoundException(ConstantError.NEWS_NOT_FOUND + id);
    });
    news.setTitle(request.getTitle());
    news.setContent(request.getMessage());
    news.setImg_url(request.getImg_url());

    newsRepository.save(news);
    return new NewsDto(news);
  }
  public void delete(Long id) {
    News news = newsRepository.findById(id).orElseThrow(() -> {
      throw new NotFoundException(ConstantError.NEWS_NOT_FOUND + id);
    });
    newsRepository.delete(news);
  }
}
