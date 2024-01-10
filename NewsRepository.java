package news.example.news.repository;

import news.example.news.entity.NewsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

    @Query("SELECT n FROM NewsEntity n WHERE " +
            "(:publishedDateStart IS NULL OR n.publishedDate >= :publishedDateStart) AND " +
            "(:publishedDateEnd IS NULL OR n.publishedDate <= :publishedDateEnd) AND " +
            "(:titleContains IS NULL OR n.title LIKE %:titleContains%) AND " +
            "(:language IS NULL OR n.language = :language)")
    Page<NewsEntity> findByFilters(@Param("publishedDateStart") LocalDate publishedDateStart,
                                   @Param("publishedDateEnd") LocalDate publishedDateEnd,
                                   @Param("titleContains") String titleContains,
                                   @Param("language") String language,
                                   Pageable pageable);


    @Query("SELECT news FROM NewsEntity news WHERE news.author Like %:author% and  news.title Like %:title% and news.description Like %:description% and news.source Like %:source% and news.category Like %:category% and news.language=:language")
    Page<NewsEntity> getNews(@Param("author") String author,
                             @Param("title") String title,
                             @Param("description") String description,
                             @Param("source") String source,
                             @Param("category") String category,
                             @Param("language") String language,
                             Pageable pageable);

    @Query("SELECT news FROM NewsEntity news WHERE news.author Like %:author% and  news.title Like %:title% and news.description Like %:description% and news.source Like %:source% and news.language=:language")
    Page<NewsEntity> getNews(@Param("author") String author,
                             @Param("title") String title,
                             @Param("description") String description,
                             @Param("source") String source,
                             @Param("language") String language,
                             Pageable pageable);


    @Query("SELECT news FROM NewsEntity news WHERE news.author Like %:author% and  news.title Like %:title% and news.description Like %:description% and news.language=:language")
    Page<NewsEntity> findByAuthorTitleDescriptionAndLanguage(@Param("author") String author,
                             @Param("title") String title,
                             @Param("description") String description,
                             @Param("language") String language,
                             Pageable pageable);


    @Query("SELECT news FROM NewsEntity news WHERE news.author Like %:author% and  news.title Like %:title% and news.description Like %:description%")
    Page<NewsEntity> getNews(@Param("author") String author,
                             Pageable pageable);

    @Query("SELECT news FROM NewsEntity news WHERE news.author LIKE %:author% AND news.title LIKE %:title% AND news.description LIKE %:description% AND news.language = :language")
    Page<NewsEntity> getNews(@Param("author") String author,
                             @Param("title") String title,
                             @Param("description") String description,
                             @Param("language") String language,
                             Pageable pageable);

}