package news.example.news.mapper;


import news.example.news.entity.NewsEntity;
import news.example.news.outbound.NewsData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    NewsEntity toEntity(NewsData newsData);

}
