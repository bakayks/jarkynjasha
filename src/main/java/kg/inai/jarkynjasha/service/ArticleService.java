package kg.inai.jarkynjasha.service;

import kg.inai.jarkynjasha.entity.Article;
import kg.inai.jarkynjasha.model.ArticleModel;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    Article getArticleById(Long id);

    void putById(Long id, ArticleModel articleModel);

    void create(ArticleModel articleModel);

    String deleteById(Long id);
}
