package kg.inai.jarkynjasha.controller;

import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.entity.User;
import kg.inai.jarkynjasha.model.NewsModel;
import kg.inai.jarkynjasha.service.NewsService;
import kg.inai.jarkynjasha.service.UserService;
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
@RequestMapping("user/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public String getNewsList(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList";
    }
}
