package kg.inai.jarkynjasha.controller;

import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.model.NewsModel;
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

@CrossOrigin
@Controller
@RequestMapping("news/")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/list")
    public String getNewsList(@PageableDefault(7) Pageable pageable,
                                      Model model) {
        Page<News> newsList = newsService.getAllNewsWithPagination(pageable);
        model.addAttribute("news", newsList);
        return "newsList";
    }

    @GetMapping(value = "/{id}")
    public String newsProfile(@PathVariable(required = false) Long id, Model model) {
        News news = newsService.getNewsById(id);
        model.addAttribute("news", news);
        model.addAttribute("add", false);
        return "newsForm";

    }

    @PostMapping("update/{id}")
    public String updateNews(@PathVariable("id") Long id,
                                     @Valid @ModelAttribute("news") NewsModel newsModel) {
        newsService.putById(id, newsModel);
        return "redirect:/news/list";
    }


    @GetMapping(value = "/form")
    public String newsForm(Model model) {
        model.addAttribute("add", true);
        return "newsForm";
    }

    @PostMapping(value = "/create")
    public String addNews(@Valid @ModelAttribute("news") NewsModel newsModel,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("add", true);
            return "newsForm";
        }
        newsService.create(newsModel);
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

