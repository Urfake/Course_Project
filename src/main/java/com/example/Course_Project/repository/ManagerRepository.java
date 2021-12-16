package com.example.Course_Project.repository;

import com.example.Course_Project.models.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager, Long> {

   Manager findByUserId(Long user_id);
   Manager findByName(String name);
}
