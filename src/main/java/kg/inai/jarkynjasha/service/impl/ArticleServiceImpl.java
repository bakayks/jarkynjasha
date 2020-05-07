package kg.inai.jarkynjasha.service.impl;

import kg.inai.jarkynjasha.entity.Article;
import kg.inai.jarkynjasha.exception.RecordNotFoundException;
import kg.inai.jarkynjasha.model.ArticleModel;
import kg.inai.jarkynjasha.repository.ArticleRepository;
import kg.inai.jarkynjasha.service.ArticleService;
import kg.inai.jarkynjasha.util.UtilBase64Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException("Record not found with id:" + id));
    }

    @Override
    public void putById(Long id, ArticleModel articleModel) {
        articleRepository.findById(id)
                .map(newArticle -> {
                    newArticle.setTitle(articleModel.getTitle());
                    newArticle.setDescription(articleModel.getDescription());
                    if (articleModel.getImage() != null && articleModel.getImage().getContentType().contains("image")) {
                        newArticle.setImage(UtilBase64Image.encoder(articleModel.getImage()));
                    }
                    newArticle.setCreatedDate(articleModel.getCreatedDate());
                    return articleRepository.save(newArticle);
                })
                .orElseThrow(() ->
                        new RecordNotFoundException("Record not found with id:" + id));
    }

    @Override
    public void create(Article article) {
        articleRepository.save(article);
    }

    @Override
    public String deleteById(Long id) {
        articleRepository.deleteById(id);
        return "Article number " + id + " has been deleted!";
    }
}
