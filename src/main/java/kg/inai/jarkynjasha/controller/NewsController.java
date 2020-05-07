package kg.inai.jarkynjasha.controller;

import kg.inai.jarkynjasha.entity.CrisisСenter;
import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.service.CrisisCenterService;
import kg.inai.jarkynjasha.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("news/")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private CrisisCenterService crisisCenterService;

    @ModelAttribute("crisisСenters")
    public List<CrisisСenter> getCrisisCenters() {
        List<CrisisСenter> crisisСenters = crisisCenterService.findAll();
        return crisisСenters;
    }

    @GetMapping(value = "/list")
    public String getNewsList(Model model) {
        List<News> newsList = newsService.findAll();
        model.addAttribute("newsList", newsList);
        model.addAttribute("bool", true);
        model.addAttribute("centers", getCrisisCenters());
        return "newsList";
    }

    @GetMapping(value = "/{id}")
    public String newsProfile(@PathVariable("id") Long id, Model model) {
        News news = newsService.getNewsById(id);
        int length = newsService.findAll().size();
        List<News> lastThreeNews = newsService.findAll().subList(length-4, length-1);
        model.addAttribute("news", news);
        model.addAttribute("lastThreeNews", lastThreeNews);
        return "newsDetail";

    }

    @PostMapping("update/{id}")
    public String updateNews(@PathVariable("id") Long id,
                                     @Valid @ModelAttribute("news") News news) {
        newsService.putById(id, news);
        return "redirect:/news/list";
    }


    @GetMapping(value = "/form")
    public String newsForm(Model model) {
        return "newsForm";
    }

    @PostMapping(value = "/create")
    public String addNews(@Valid @ModelAttribute("news") News news,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("add", true);
            return "newsForm";
        }
        newsService.create(news);
        return "redirect:list";
    }

    @PostMapping("/delete/{id}")
    public String deleteNews(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            newsService.deleteById(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("has_exception", true);
            redirectAttributes.addFlashAttribute("exception_text", "Couldn't delete on table organization violates foreign key constraint ");
            return "redirect:/news/" + id;
        }
        return "redirect:/news/list";
    }
}

