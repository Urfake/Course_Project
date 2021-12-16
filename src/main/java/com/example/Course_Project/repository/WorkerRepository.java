package com.example.Course_Project.repository;

import com.example.Course_Project.models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
public interface WorkerRepository extends CrudRepository<Worker, Long> {
    Worker findByUserId(Long user_id);
    Worker findByName(String name);

}
