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
public class QuestionnaireController {

    @Autowired
    private CrisisCenterService crisisCenterService;

    @ModelAttribute("crisisСenters")
    public List<CrisisСenter> getCrisisCenters() {
        List<CrisisСenter> crisisСenters = crisisCenterService.findAll();
        return crisisСenters;
    }

    @GetMapping("/questionnaire")
    public String getMain(Model model){
        model.addAttribute("centers", getCrisisCenters());
        return "questionnaire";
    }
}