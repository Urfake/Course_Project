package com.example.Course_Project.repository;

import com.example.Course_Project.models.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
   Director findByUserId(Long user_id);
   Director findByName(String name);
}
