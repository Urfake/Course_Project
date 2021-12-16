//package com.example.Course_Project.controller;

import com.example.Course_Project.models.*;
import com.example.Course_Project.repository.DirectorRepository;
import com.example.Course_Project.repository.ManagerRepository;
import com.example.Course_Project.repository.UserRepository;
import com.example.Course_Project.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

//@Controller
//public class UserController {
//    @Autowired
//    DirectorRepository directorRepository;
//    @Autowired
//    ManagerRepository managerRepository;
//    @Autowired
//    WorkerRepository workerRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//    @GetMapping("/registration")
//    public String registration(Model model) {
//        return "registration";
//    }
//    @PostMapping("/registration")
//    public String registrate(User user, Map<String, Object> model){
//        User userFromDb = userRepository.findByUsername(user.getUsername());
//
//        if (userFromDb != null) {
//            model.put("message", "User exists!");
//            return "registration";
//        }
//        user.setRoles(Collections.singleton(Role.WORKER));
//        user.setPassword(NoOpPasswordEncoder.getInstance().encode(user.getPassword()));
//        userRepository.save(user);
//        return "redirect:/login";
//    }
//}
