package kg.inai.jarkynjasha.controller;

import kg.inai.jarkynjasha.entity.Article;
import kg.inai.jarkynjasha.entity.CrisisСenter;
import kg.inai.jarkynjasha.entity.Event;
import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.service.ArticleService;
import kg.inai.jarkynjasha.service.CrisisCenterService;
import kg.inai.jarkynjasha.service.EventService;
import kg.inai.jarkynjasha.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@CrossOrigin
@Controller
public class MainController {
    @Autowired
    private CrisisCenterService crisisCenterService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private EventService eventService;

    @ModelAttribute("crisisСenters")
    public List<CrisisСenter> getCrisisCenters() {
        List<CrisisСenter> crisisСenters = crisisCenterService.findAll();
        return crisisСenters;
    }

    @GetMapping("/")
    public String get(Model model){
        List<News> newsList = newsService.findAll().subList(0, 3);
        List<Article> articleList = articleService.findAll().subList(0, 3);
        List<Event> eventList = eventService.findAll().subList(0, 3);
        model.addAttribute("isMain", true);
        model.addAttribute("centers", getCrisisCenters());
        model.addAttribute("newsList", newsList);
        model.addAttribute("articleList", articleList);
        model.addAttribute("eventList", eventList);
        return "index";
    }

    @GetMapping("/main")
    public String getMain(Model model){
        List<News> newsList = newsService.findAll().subList(0, 3);
        List<Article> articleList = articleService.findAll().subList(0, 3);
        List<Event> eventList = eventService.findAll().subList(0, 3);
        model.addAttribute("isMain", true);
        model.addAttribute("centers", getCrisisCenters());
        model.addAttribute("newsList", newsList);
        model.addAttribute("articleList", articleList);
        model.addAttribute("eventList", eventList);
        return "index";
    }

    @GetMapping("/faq")
    public String getFaq(Model model){
        model.addAttribute("centers", getCrisisCenters());
        return "faq";
    }
}
