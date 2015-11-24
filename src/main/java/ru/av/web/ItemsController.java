package ru.av.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.av.service.BasketService;
import ru.av.service.ItemsService;

@Controller
public class ItemsController {

    @Autowired
    ItemsService itemsService;

    @Autowired
    BasketService basketService;

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("redirect:/catalog");
    }

    @RequestMapping("/catalog/item/{itemId}")
    public ModelAndView item(@PathVariable Long itemId) {
        return new ModelAndView("/item", "item", itemsService.findById(itemId));
    }

    @RequestMapping("/catalog/item/buy/{itemId}")
    public ModelAndView buyItem(@PathVariable Long itemId) {
        basketService.addItem(itemsService.findById(itemId));
        return new ModelAndView("redirect:/catalog");
    }

    @RequestMapping("/catalog")
    public String listItems(ModelMap modelMap) {
        modelMap.addAttribute("items", itemsService.getList());
        modelMap.addAttribute("sum", basketService.getSum());
        return "list";
    }

    @RequestMapping("/catalog/{catId}")
    public String listCategoryItems(@PathVariable Long catId, ModelMap modelMap) {
        modelMap.addAttribute("items", itemsService.getCategoryList(catId));
        modelMap.addAttribute("sum", basketService.getSum());
        return "list";
    }

    @RequestMapping("/basket")
    public String basket(ModelMap model) {
        model.addAttribute("rows", basketService.getPositions());
        return "basket";
    }

    @RequestMapping("/basket/buy")
    public ModelAndView buy(){
        basketService.buy();
        return new ModelAndView("redirect:/catalog");
    }

    @RequestMapping("/admin/")
    public String admin(ModelMap model){
        model.addAttribute("items", itemsService.getFinishedItems());
        return "admin";
    }
}
