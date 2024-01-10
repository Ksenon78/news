package news.example.news.outbondhandler;

import news.example.news.entity.NewsEntity;
import news.example.news.mapper.NewsMapper;
import news.example.news.outbound.NewsApiResponse;
import news.example.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewsHandlerService {

    private final NewsMapper newsMapper;
    private final NewsRepository newsRepository;

    @Value("${mediastack.api.key}")
    private String apiKey;

    public NewsHandlerService(NewsMapper newsMapper, NewsRepository newsRepository) {
        this.newsMapper = newsMapper;
        this.newsRepository = newsRepository;
    }


    @Scheduled(fixedRate = 10000)
    public void fetchAndSaveNewsScheduled() {
        fetchDataAndSaveToDatabase();
    }

    public void fetchDataAndSaveToDatabase() {
       String apiUrl = "http://api.mediastack.com/v1/news?access_key=02132885fa35b1256c313732d6426348";
        RestTemplate restTemplate = new RestTemplate();
        NewsApiResponse responseEntity = restTemplate.getForObject(apiUrl, NewsApiResponse.class);
        if (responseEntity != null) {
            List<NewsEntity> newsEntityList = responseEntity.getData()
                    .stream().map(newsMapper::toEntity).collect(Collectors.toList());
            newsRepository.saveAll(newsEntityList);
        } else {
            System.out.println("responseEntity is null");
        }
    }
}
