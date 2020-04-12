package sunya.projects.SpringWebMvcEvent.EventApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sunya.projects.SpringWebMvcEvent.EventApp.models.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<Event> events = new ArrayList<>(Arrays.asList(
            new Event("Wake up early"),
            new Event("Breakfast with disney plus")
    ));

    @GetMapping("")
    public String displayAllEvents(Model model) {
        model.addAttribute("events", events);
        return "events/mainEventDisplay";
    }

    @GetMapping("create")
    public String createEventForm() {
        return "events/create";
    }

    @PostMapping("create")
    public String processNewEventCreated(@RequestParam(required = false) String eventName, Model model) {
        events.add(new Event(eventName));
        return "redirect:";
    }

}
