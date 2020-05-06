package kg.inai.jarkynjasha.controller;

import kg.inai.jarkynjasha.entity.Diary;
import kg.inai.jarkynjasha.model.DiaryModel;
import kg.inai.jarkynjasha.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("diary/")
public class DiaryController {
    @Autowired
    private DiaryService diaryService;


    @GetMapping(value = "/list")
    public String getAll(Model model) {
        List<Diary> diaryList=diaryService.findAll();
        model.addAttribute("articles", diaryList);
        return "diaryList";
    }

    @GetMapping(value = "/{id}")
    public Diary getById(@PathVariable("id") Long id) {
        return diaryService.getDiaryById(id);
    }


    @PostMapping
    public void create(@RequestBody DiaryModel diary) {
        diaryService.create(diary);
    }

    @DeleteMapping
    public void deleteById(Long id) {
        diaryService.deleteById(id);
    }
}



