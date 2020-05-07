package kg.inai.jarkynjasha.controller;

import kg.inai.jarkynjasha.entity.Article;
import kg.inai.jarkynjasha.entity.CrisisСenter;
import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.model.ArticleModel;
import kg.inai.jarkynjasha.service.ArticleService;
import kg.inai.jarkynjasha.service.CrisisCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("articles/")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CrisisCenterService crisisCenterService;

    @ModelAttribute("crisisСenters")
    public List<CrisisСenter> getCrisisCenters() {
        List<CrisisСenter> crisisСenters = crisisCenterService.findAll();
        return crisisСenters;
    }

    @GetMapping(value = "/list")
    public String getAll(Model model) {
        List<Article> articleList=articleService.findAll();
        model.addAttribute("articleList", articleList);
        model.addAttribute("bool", true);
        model.addAttribute("centers", getCrisisCenters());
        return "articleList";
    }

    @GetMapping(value = "/{id}")
    public String newsProfile(@PathVariable("id") Long id, Model model) {
        Article article = articleService.getArticleById(id);
        int length = articleService.findAll().size();
        List<Article> lastThreeArt = articleService.findAll().subList(length-4, length-1);
        model.addAttribute("article", article);
        model.addAttribute("lastThreeArticles", lastThreeArt);
        model.addAttribute("centers", getCrisisCenters());
        return "articleDetail";

    }

    @PostMapping(value = "/create")
    public String addArticle(@Valid @ModelAttribute("article") Article article) {
        articleService.create(article);
        return "redirect:/articles/list";
    }

    @DeleteMapping
    public void deleteById(Long id) {
        articleService.deleteById(id);
    }
}



