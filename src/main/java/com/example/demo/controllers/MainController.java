package com.example.demo.controllers;

//import ch.qos.logback.core.model.Model;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    AppointmentRepository appointments;

    @Autowired
    NoteRepository note;

    @Autowired
    PhysicianRepository physicians;

    @Autowired
    UserRepository users;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    @PostMapping("/")
    public String addUser(@ModelAttribute User user) {
        users.save(user);
        return "redirect:/";
    }
//    @GetMapping("/appointment")
//    public String appointment(Integer id, Model model) {
//        User user = users.findById(id).orElse(null);
//        List<Appointment>   userApps = appointments.findByUser(id);
//
//        model.addAttribute("appointments", userApps);
//
//        return "redirect:/appointment?user=";
//    }
//    @PostMapping("/appointment")
//    public String makeApp(@ModelAttribute Appointment app) {
//        appointments.save(app);
//
//        return "redirect:/appointment?user=";
//    }
//
//
//
//    @GetMapping("/edit")
//    public String editUser(Integer id, Model model) {
//        User user = users.findById(id).orElse(null);
//        model.addAttribute("user", user);
//        return "/edit";
//    }
//
//    @PostMapping("/editUser")
//    public String editUser(@ModelAttribute User user, Integer id) {
//        User updateuser = users.findById(id).orElse(null);
//
//        updateuser.setFirstName(user.getFirstName());
//        updateuser.setLastName(user.getLastName());
//        updateuser.setEmail(user.getEmail());
//        updateuser.setPhone(user.getPhone());
//        updateuser.setNotification(user.isNotification(0));
//
//        users.save(updateuser);
//        return "redirect:/editUser";
//    }
//
//    @GetMapping("/appointment")
//    public String appointment(Model model) {
//        return "/appointment";
//    }
    
}
