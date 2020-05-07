package kg.inai.jarkynjasha.controller;

import kg.inai.jarkynjasha.entity.CrisisСenter;
import kg.inai.jarkynjasha.entity.Event;
import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.service.CrisisCenterService;
import kg.inai.jarkynjasha.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("event/")
public class EventController {
    @Autowired
    private EventService eventService;

    @Autowired
    private CrisisCenterService crisisCenterService;

    @ModelAttribute("crisisСenters")
    public List<CrisisСenter> getCrisisCenters() {
        List<CrisisСenter> crisisСenters = crisisCenterService.findAll();
        return crisisСenters;
    }

    @GetMapping(value = "/list")
    public String getEventsList(Model model) {
        List<Event> eventList = eventService.findAll();
        model.addAttribute("eventList", eventList);
        model.addAttribute("bool", true);
        model.addAttribute("centers", getCrisisCenters());
        return "eventList";
    }

    @PostMapping("update/{id}")
    public String updateEvent(@PathVariable("id") Long id,
                             @Valid @ModelAttribute("event") Event event) {
        eventService.putById(id, event);
        return "redirect:/event/list";
    }

    @PostMapping(value = "/create")
    public String addEvent(@Valid @ModelAttribute("event") Event event) {
        eventService.create(event);
        return "redirect:/event/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            eventService.deleteById(id);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("has_exception", true);
            redirectAttributes.addFlashAttribute("exception_text", "Couldn't delete on table organization violates foreign key constraint ");
            return "redirect:/event/" + id;
        }
        return "redirect:/event/list";
    }
}
