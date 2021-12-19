package com.example.Course_Project.controller;

import com.example.Course_Project.models.User;
import com.example.Course_Project.models.Worker;
import com.example.Course_Project.repository.UserRepository;
import com.example.Course_Project.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WorkerController {
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/worker")
    public String main(Model model){
        Authentication loggedUser1 = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = userRepository.findByUsername(loggedUser1.getName());
        Worker worker = workerRepository.findByUserId(loggedUser.getId());
        int salaryyear = worker.getSalary()*12;
        model.addAttribute("worker_name", worker.getName());
        model.addAttribute("worker_salary", worker.getSalary());
        model.addAttribute("worker_time", worker.getTime_of_work());
        model.addAttribute("worker_week", worker.getWeekend());
        model.addAttribute("worker_prize", worker.getPrize());
        model.addAttribute("worker_year", salaryyear);
        return "worker";
    }
}