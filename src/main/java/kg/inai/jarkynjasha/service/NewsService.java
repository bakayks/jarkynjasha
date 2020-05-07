package kg.inai.jarkynjasha.service;

import kg.inai.jarkynjasha.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface NewsService {
    List<News> findAll();

    Page<News> getAllNewsWithPagination(Pageable pageable);

    News getNewsById(Long id);

    void putById(Long id, News news);

    void create(News news);

    String deleteById(Long id);
}
