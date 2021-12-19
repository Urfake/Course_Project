package com.example.Course_Project.controller;

import com.example.Course_Project.models.Manager;
import com.example.Course_Project.models.Role;
import com.example.Course_Project.models.User;
import com.example.Course_Project.models.Worker;
import com.example.Course_Project.repository.ManagerRepository;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;


@Controller
public class DirectorController {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/director")
    public String director(Model model){
        return "director";
    }
    @GetMapping("/director/delete")
    public String delete(Model model){
        Iterable<Manager> managers = managerRepository.findAll();
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("managers",managers);
        model.addAttribute("workers",workers);
        return "director_delete";
    }
    @GetMapping("/director/change")
    public String director_change(Model model){
        Iterable<Manager> managers = managerRepository.findAll();
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("managers",managers);
        model.addAttribute("workers",workers);
        return "director_list";
    }
    @GetMapping("/director/list")
    public String director_list(Model model){
        Iterable<Manager> managers = managerRepository.findAll();
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("managers",managers);
        model.addAttribute("workers",workers);
        return "director_list";
    }

    @GetMapping("/director/add/worker")
    public String add_worker(Model model){
        return "director_add_worker";
    }

    @PostMapping("/director/add/worker")
    public String director_work_add(@RequestParam String username,@RequestParam String password,@RequestParam String name,@RequestParam int salary, Model model){
        Worker worker = new Worker(name, salary);
        User user = new User(username, password);
        worker.setUser(user);
        user.setRoles(Collections.singleton(Role.WORKER));
        user.setPassword(NoOpPasswordEncoder.getInstance().encode(user.getPassword()));
        userRepository.save(user);
        workerRepository.save(worker);
        return "redirect:/director";
    }

    @GetMapping("/director/add/manager")
    public String add_manager(Model model){
        return "director_add_manager";
    }

    @PostMapping("/director/add/manager")
    public String director_man_add(@RequestParam String username,@RequestParam String password,@RequestParam String name,@RequestParam int salary, Model model){
        Manager manager = new Manager(name, salary);
        User user = new User(username, password);
        manager.setUser(user);
        user.setRoles(Collections.singleton(Role.MANAGER));
        user.setPassword(NoOpPasswordEncoder.getInstance().encode(user.getPassword()));
        userRepository.save(user);
        managerRepository.save(manager);
        return "redirect:/director";
    }

    @GetMapping("/director/manager/{id}")
    public String view_manager(@PathVariable(value = "id") long id, Model model){
        if (!managerRepository.existsById(id))
            return "redirect:/director";

        Optional<Manager> man = managerRepository.findById(id);
        ArrayList<Manager> manager = new ArrayList<>();
        man.ifPresent(manager::add);
        model.addAttribute("manager",manager);
        return "director_view_manager";
    }
    @PostMapping("/director/manager/{id}")
    public String director_man_edit(@PathVariable(value = "id") long id,@RequestParam String name,@RequestParam String time_of_work,@RequestParam String weekend,@RequestParam int salary, Model model){
        Manager manager = managerRepository.findById(id).orElseThrow();
        manager.setName(name);
        manager.setTime_of_work(time_of_work);
        manager.setWeekend(weekend);
        manager.setSalary(salary);
        managerRepository.save(manager);
        return "redirect:/director";
    }

    @PostMapping("/director/manager/{id}/remove")
    public String director_man_remove(@PathVariable(value = "id") long id, Model model){
        Manager manager = managerRepository.findById(id).orElseThrow();
        User user = userRepository.getById(manager.getUser().getId());
        managerRepository.delete(manager);
        userRepository.delete(user);
        return "redirect:/director";
    }

    @GetMapping("/director/worker/{id}")
    public String view_worker(@PathVariable(value = "id") long id, Model model){
        if (!workerRepository.existsById(id))
            return "redirect:/director";

        Optional<Worker> work = workerRepository.findById(id);
        ArrayList<Worker> worker = new ArrayList<>();
        work.ifPresent(worker::add);
        model.addAttribute("worker",worker);
        return "director_view_worker";
    }
    @PostMapping("/director/worker/{id}")
    public String director_worker_edit(@PathVariable(value = "id") long id,@RequestParam String name,@RequestParam String time_of_work,@RequestParam String weekend,@RequestParam int salary,@RequestParam int prize, Model model){
        Worker worker = workerRepository.findById(id).orElseThrow();
        worker.setName(name);
        worker.setTime_of_work(time_of_work);
        worker.setWeekend(weekend);
        worker.setSalary(salary);
        worker.setPrize(prize);

        workerRepository.save(worker);
        return "redirect:/director";
    }

    @PostMapping("/director/worker/{id}/remove")
    public String director_worker_remove(@PathVariable(value = "id") long id, Model model){
        Worker worker = workerRepository.findById(id).orElseThrow();
        User user = userRepository.getById(worker.getUser().getId());
        workerRepository.delete(worker);
        userRepository.delete(user);
        return "redirect:/director";
    }
}