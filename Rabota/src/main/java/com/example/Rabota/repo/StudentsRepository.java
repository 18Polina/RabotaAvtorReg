package com.example.Rabota.repo;

import com.example.Rabota.Models.Students;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Students,Long> {
    List<Students> findByLastname( String lastname);
    List<Students> findByLastnameContains (String lastname);
}
