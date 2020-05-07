package kg.inai.jarkynjasha.controller;

import kg.inai.jarkynjasha.entity.User;
import kg.inai.jarkynjasha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
