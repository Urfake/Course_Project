package com.example.Course_Project.controller;

import com.example.Course_Project.models.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model){
        return "index";
    }
    @RequestMapping(value = "/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        Collection<? extends GrantedAuthority> authorities;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        authorities = auth.getAuthorities();
        String myRole = authorities.toArray()[0].toString();
        String admin = Role.DIRECTOR.getAuthority();
        if (myRole.equals(admin)) {
            return "redirect:/director";
        }
        else if (myRole.equals(Role.MANAGER.getAuthority())){
            return "redirect:/HR";
        }
        else
            return "redirect:/worker";
    }
}
