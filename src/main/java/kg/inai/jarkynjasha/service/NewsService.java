package kg.inai.jarkynjasha.service;

import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.model.NewsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface NewsService {
    List<News> findAll();

    Page<News> getAllNewsWithPagination(Pageable pageable);

    News getNewsById(Long id);

    void putById(Long id, NewsModel newsModel);

    void create(NewsModel newsModel);

    String deleteById(Long id);
}
