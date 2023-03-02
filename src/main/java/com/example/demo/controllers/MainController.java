package com.example.demo.controllers;

//import ch.qos.logback.core.model.Model;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;


import javax.management.remote.JMXAuthenticator;
import java.io.IOException;
import java.util.List;


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
//    @PostMapping("/signup")
//    public String addUser(Model model, @Valid @ModelAttribute User newUser, BindingResult res) {
//        if (newUser.getPasswords().trim().equals("")){
//            FieldError error = new FieldError("user", "password",
//                    "Password cannot be empty");
//            res.addError(error);
//        }
//        if (res.hasErrors()){
//            model.addAttribute("user", newUser);
//
//            return "/signup";
//        }
//        users.save(newUser);
//        return "redirect:/appointment";
//    }

    @PostMapping("/signup")
    public String addUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPasswords());
        user.setPasswords(encodedPassword);

        users.save(user);

        return "redirect:/appointment";
    }
//    @PostMapping("/")
//    public String userLogIn(@ModelAttribute User user) {
//
//        return "redirect:/appointment";
//    }

    @PostMapping("/")
    public String adminLogIn(@ModelAttribute User user) {

        return "redirect:/schedule";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(Model model,  @PathVariable int id) {
        User user = users.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "/editUser";
    }

    @PostMapping("/editUser")
    public String editUser(Model model, @Valid @ModelAttribute User updateuser, BindingResult res) {
        if (updateuser.getPasswords().trim().equals("")){
            var previousPassword = users.findById(updateuser.getUserId()).get().getPasswords();
            updateuser.setPasswords(previousPassword);
        }
        if (res.hasErrors()){
            model.addAttribute("user", updateuser);
            return "editUser";
        }
        users.save(updateuser);
        return "redirect:/editUser";
    }

//    @GetMapping("/appointment")
//    public String appointment(Model model) {
////        User user = users.findById(id).orElse(null);
//        List<Appointment> appList = appointments.findByUser(user.getUserId());
//        List<Physician> phyList = physicians.findAll();
//        model.addAttribute("phyList", phyList);
//        model.addAttribute("appList", appList);
//        return "/appointment";
//    }
//
//    @GetMapping("/new_appointment/{id}")
//    public String newAppointment(Model model,  @PathVariable int id) {
//        List<Appointment> drApps = appointments.findByPhysician(id);
//
//        model.addAttribute("phyList", phyList);
//        model.addAttribute("appList", appList);
//        return "/appointment/{id}";
//    }

    @PostMapping("/new_appointment/{id}")
    public String addAppointment(Model model,  @PathVariable int id, @Valid @ModelAttribute("appointment") Appointment newApp,
                                 BindingResult res) throws IOException {
        List<Appointment> drApps = appointments.findByPhysician(id);

        drApps.forEach(dr -> {
            if(dr.getStartTime() == newApp.getStartTime()) {
                FieldError error = new FieldError("Start Time", "Start Time", "Time slot is not available.");
                res.addError(error);
            }
        });

        if (res.hasErrors()) {
            model.addAttribute("Appointment", newApp);
            return "/appointment";
        }
        appointments.save(newApp);

        return "/appointment";
    }
    
}
