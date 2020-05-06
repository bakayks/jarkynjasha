package kg.inai.jarkynjasha.service;

import kg.inai.jarkynjasha.entity.Article;
import kg.inai.jarkynjasha.model.ArticleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    Article getArticleById(Long id);

    void putById(Long id, ArticleModel ArticleModel);

    void create(ArticleModel ArticleModel);

    String deleteById(Long id);
}
