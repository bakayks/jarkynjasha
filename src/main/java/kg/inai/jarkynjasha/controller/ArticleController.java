package kg.inai.jarkynjasha.controller;

import kg.inai.jarkynjasha.entity.Article;
import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.model.ArticleModel;
import kg.inai.jarkynjasha.model.NewsModel;
import kg.inai.jarkynjasha.service.ArticleService;
import kg.inai.jarkynjasha.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("articles/")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAll() {
        return articleService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Article getById(@PathVariable("id") Long id) {
        return articleService.getArticleById(id);
    }


    @PostMapping
    public void create(@RequestBody ArticleModel article) {
        articleService.create(article);
    }

    @DeleteMapping
    public void deleteById(Long id) {
        articleService.deleteById(id);
    }
}



