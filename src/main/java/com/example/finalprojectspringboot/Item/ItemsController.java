package com.example.finalprojectspringboot.Item;

import com.example.finalprojectspringboot.Equipment.EquipmentService;
import com.example.finalprojectspringboot.Home.ForbiddenException;
import com.example.finalprojectspringboot.Home.User;
import com.example.finalprojectspringboot.Home.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller

@RequestMapping("/items")
public class ItemsController {
    private final ItemService itemService;
    private final EquipmentService equipmentService;
    private final UserService userService;

    public ItemsController(ItemService itemService, EquipmentService equipmentService, UserService userService) {

        this.itemService = itemService;
        this.equipmentService = equipmentService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public String showPosts(Model model, @CookieValue(value = "login", defaultValue = "")
            String login, @CookieValue(value = "password", defaultValue = "") String password,
                            @CookieValue(value = "UserId", defaultValue = "0")Long userId) {
        checkLogin(login, password);
        List<Item> items = itemService.getItemsByUserId(userId);
        model.addAttribute("items", items);
        return "/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model, @CookieValue(value = "login", defaultValue = "")
            String login, @CookieValue(value = "password", defaultValue = "") String password,
                              @CookieValue(value = "UserId", defaultValue = "0")Long userId) {
        checkLogin(login, password);
        model.addAttribute("car", new Item());
        return "/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveItem(@Valid @ModelAttribute("car") Item item, BindingResult result, Model model,
                           @CookieValue(value = "login", defaultValue = "") String login,
                           @CookieValue(value = "password", defaultValue = "") String password,
                           @CookieValue(value = "UserId", defaultValue = "0")Long userId) {
        checkLogin(login, password);
        if (result.hasErrors()) {
            model.addAttribute("car", item);
            return "/add";
        }
        item.setUserId(userId);
        itemService.add(item);
        return "redirect:/items/all";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model,
                               @CookieValue(value = "login", defaultValue = "") String login,
                               @CookieValue(value = "password", defaultValue = "") String password) {
        checkLogin(login, password);
        model.addAttribute("item", itemService.get(id));
        return "/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editItem(@Valid @ModelAttribute("car") Item item, BindingResult result, Model model,
                           @CookieValue(value = "login", defaultValue = "") String login,
                           @CookieValue(value = "password", defaultValue = "") String password,
                           @CookieValue(value = "UserId", defaultValue = "0")Long userId) {
        checkLogin(login, password);
        if (result.hasErrors()) {
            model.addAttribute("car", item);
            return "/edit";
        }
        item.setUserId(userId);
        itemService.add(item);
        return "redirect:/items/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable long id, @CookieValue(value = "login", defaultValue = "") String login,
                             @CookieValue(value = "password", defaultValue = "") String password) {
        checkLogin(login, password);
        itemService.delete(id);
        return "redirect:/items/all";
    }

    @GetMapping("/show/{id}")
    public String showItem(Model model, @PathVariable long id, @CookieValue(value = "login", defaultValue = "") String login,
                           @CookieValue(value = "password", defaultValue = "") String password) {
        checkLogin(login, password);
        model.addAttribute("item", itemService.get(id).orElseThrow(EntityNotFoundException::new));
        model.addAttribute("equipments", equipmentService.findAllByItemId(id));
        return "/show";
    }

    public void checkLogin(String login, String password) {
        List<User> users1 = userService.userGetByEmail(login, password);
        List<User> users = userService.userGetByLogin(login, password);
        if (users.size() == 0 && users1.size() == 0) {
            throw new ForbiddenException();
        }


    }
}