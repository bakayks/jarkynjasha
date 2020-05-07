package kg.inai.jarkynjasha.controller;

import kg.inai.jarkynjasha.entity.Article;
import kg.inai.jarkynjasha.model.ArticleModel;
import kg.inai.jarkynjasha.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("articles/")
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    @GetMapping(value = "/list")
    public String getAll(Model model) {
        List<Article> articleList=articleService.findAll();
        model.addAttribute("articles", articleList);
        return "articleList";
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



