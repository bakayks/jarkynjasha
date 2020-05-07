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
@RequestMapping("crisisCenter/")
public class CrisisCenterController {

    @Autowired
    private CrisisCenterService crisisCenterService;


    @PostMapping(value = "/create")
    public String addCrisisСenter(@Valid @ModelAttribute("crisisСenter") CrisisСenter crisisСenter,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("add", true);
            return "redirect:/news/list";
        }
        crisisCenterService.create(crisisСenter);
        return "redirect:/news/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteCrisisСenter(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            crisisCenterService.deleteById(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("has_exception", true);
            redirectAttributes.addFlashAttribute("exception_text", "Couldn't delete on table organization violates foreign key constraint ");
            return "redirect:/news/list";
        }
        return "redirect:/news/list";
    }
}

