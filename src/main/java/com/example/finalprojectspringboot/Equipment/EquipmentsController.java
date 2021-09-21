package com.example.finalprojectspringboot.Equipment;

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
@RequestMapping("/equipments")
public class EquipmentsController {
    private final EquipmentService equipmentService;
    private final UserService userService;

    public EquipmentsController(EquipmentService equipmentService, UserService userService) {

        this.equipmentService = equipmentService;
        this.userService = userService;
    }

    @RequestMapping(value = "/add/{itemId}", method = RequestMethod.GET)
    public String showAddForm(@PathVariable Long itemId, Model model, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password) {
        checkLogin(login, password);
        Equipment e = new Equipment();
        e.setItemId(itemId);
        model.addAttribute("equipment", e);
        return "/addEquipment";
    }
    @RequestMapping(value = "/saveEquipment", method = RequestMethod.POST)
    public String saveEquipment(@Valid Equipment equipment, BindingResult result) {
        if (result.hasErrors()) {
            return "/addEquipment";
        }
        equipmentService.add(equipment);
        return "redirect:/items/show/" + equipment.getItemId();
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable long id, Model model, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password) {
        checkLogin(login, password);
        model.addAttribute("equipment", equipmentService.get(id));
        return "/editEquipment";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editEquipment(@Valid Equipment equipment, BindingResult result) {
        if (result.hasErrors()) {
            return "/editEquipment";
        }
        equipmentService.add(equipment);
        return "redirect:/items/show/" + equipment.getItemId();
    }
    @GetMapping("/delete/{id}")
    public String deleteEquipment(@PathVariable long id, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password) {
        checkLogin(login, password);
        Long itemId = equipmentService.get(id).get().getItemId();
        equipmentService.delete(id);
        return "redirect:/items/show/" + itemId;
    }
    @GetMapping("/show/{id}")
    public String showItem(Model model, @PathVariable long id, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password) {
        checkLogin(login, password);
        model.addAttribute("equipment", equipmentService.get(id).orElseThrow(EntityNotFoundException::new));
        return "/showEquipment";
    }
    public void checkLogin(String login, String password) {
        List<User> users1 = userService.userGetByEmail(login, password);
        List<User> users = userService.userGetByLogin(login, password);
        if (users.size() == 0 && users1.size() == 0) {
            throw new ForbiddenException();
        }


    }
}
