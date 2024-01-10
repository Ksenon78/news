package news.example.news.service;

import news.example.news.entity.NewsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;


public interface NewsService {
    Page<NewsEntity> findByFilters(LocalDate publishedDate, String author, String category, String description, String source, String titleContains, String language, Pageable pageable);
}
