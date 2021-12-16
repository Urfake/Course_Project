package com.example.Course_Project.controller;

import com.example.Course_Project.models.Role;
import com.example.Course_Project.models.User;
import com.example.Course_Project.models.Worker;
import com.example.Course_Project.repository.UserRepository;
import com.example.Course_Project.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Optional;


@Controller
public class ManagerController {

    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/HR")
    public String main(Model model){
        return "HR";
    }
    @GetMapping("/HR/add")
    public String add(Model model){
        return "HRadd";
    }
    @PostMapping("/HR/add")
    public String add(@RequestParam String username, @RequestParam String password, @RequestParam String name, @RequestParam int salary,@RequestParam String time_of_work,@RequestParam String weekend, Model model){
        Worker worker = new Worker(name, time_of_work, weekend, salary);
        User user = new User(username, password);
        worker.setUser(user);
        user.setRoles(Collections.singleton(Role.WORKER));
        user.setPassword(NoOpPasswordEncoder.getInstance().encode(password));
        userRepository.save(user);
        workerRepository.save(worker);
        return "redirect:/HR";
    }

    @GetMapping("/HR/list")
    public String list(Model model){
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers",workers);
        return "HRlist";
    }
    @GetMapping("HR/delete")
    public String delete(Model model){
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers",workers);
        return "HRdel";
    }
    @PostMapping("/HR/{id}/remove")
    public String delete(@PathVariable(value = "id") long id, Model model){
        Worker worker = workerRepository.findById(id).orElseThrow();
        User user = userRepository.getById(worker.getUser().getId());
        workerRepository.delete(worker);
        userRepository.delete(user);
        return "redirect:/HR";
    }
}