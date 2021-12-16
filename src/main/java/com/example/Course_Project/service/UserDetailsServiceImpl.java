package com.example.Course_Project.service;

import com.example.Course_Project.models.Role;
import com.example.Course_Project.models.User;
import com.example.Course_Project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails loadedUser;
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        try {
            User client = userRep.findByUsername(username);
            for (Role role : client.getRoles()){
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
            }
            loadedUser = new org.springframework.security.core.userdetails.User(
                    client.getUsername(), client.getPassword(),
                    grantedAuthorities);
        } catch (Exception repositoryProblem) {

            throw new
                    InternalAuthenticationServiceException(repositoryProblem.getMessage(),
                    repositoryProblem);
        }
        return loadedUser;
    }
}