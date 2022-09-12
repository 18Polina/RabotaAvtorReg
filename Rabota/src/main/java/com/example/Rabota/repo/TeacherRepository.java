package com.example.Rabota.repo;

import com.example.Rabota.Models.Students;
import com.example.Rabota.Models.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {
    List<Teacher> findBySurname(String surname);
    List<Teacher> findBySurnameContains(String surname);


}
