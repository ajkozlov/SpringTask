package ru.av.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemsController {

    @RequestMapping("/myindex")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
