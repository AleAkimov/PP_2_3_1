package ru.akimov.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.akimov.spring.servise.UserService;
import ru.akimov.spring.model.User;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        //получение всех юзеров и передача в представление
        return "users_d";
    }
    @GetMapping("/new") //форма для добавления юзера
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "new_d";
    }
    @PostMapping()
    public String addUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_d";
        }
        userService.save(user);
        return "redirect:/users"; //после добавления юзера переход на страницу со всеми юзерами в таблице
    }

    @GetMapping("/edit")
    public String editUsers(@RequestParam ("id")int id, Model model) {
        //получение юзера по id из дао и передача на представление
        model.addAttribute("user", userService.findById(id));
//        userService.findById(id);
        return "edit_d";
    }
    @PatchMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_d";
        }
        userService.update(user);
        return "redirect:/users";
    }
//    @PostMapping("/delete")
//    public String deleteUser(@RequestParam ("id")int id) {
//        userService.delete(id);
//        return "users_d";
//    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        User user = userService.findById(id);
        if (user != null) {
            userService.delete(id);
        }
        return "redirect:/users";
    }
}
//@Controller
//@RequestMapping("/users")
//public class UsersController {
//
//    private final UserService userService;
//
//    @Autowired
//    public UsersController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping()
//    public String printUser(ModelMap model) {
//        model.addAttribute("users", userService.getAllUsers());
//        return "users";
//    }
//
//    @PostMapping("/adduser")
//    public String addUser(@RequestParam("age") Integer age,
//                          @RequestParam("name") String name,
//                          @RequestParam("surname") String surname) {
//        User user = new User();
//        user.setAge(age);
//        user.setName(name);
//        user.setSurname(surname);
//        userService.save(user);
//        return "redirect:/";
//    }
//
//    @PostMapping("/deleteuser")
//    public String delete(@RequestParam("id") int id) {
//        User user = userService.getByIdUser(id);
//        if (user != null) {
//            userService.delete(user);
//        }
//        return "redirect:/";
//    }
//
//    @PostMapping("/updateUser")
//    public String update(@ModelAttribute User user) {
//        userService.update(user);
//        return "redirect:/";
//    }
//}