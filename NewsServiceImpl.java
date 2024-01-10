package news.example.news.service;

import news.example.news.entity.NewsEntity;
import news.example.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }


    @Override
    public Page<NewsEntity> findByFilters(LocalDate publishedDate, String author, String category, String description, String source, String titleContains, String language, Pageable pageable) {
        if (category != null) {
            return newsRepository.getNews(author, titleContains, description, source, category, language, pageable);
        }

        return newsRepository.getNews(author, titleContains, description, source, language, pageable);



        }


    public Page<NewsEntity> findByFilters1(LocalDate publishedDate, String author, String category, String description, String source, String titleContains, String language, Pageable pageable) {
        return null;
    }
}