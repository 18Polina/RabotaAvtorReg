package com.example.Rabota.Controller;

import com.example.Rabota.Models.Students;
import com.example.Rabota.Models.Teacher;
import com.example.Rabota.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    @GetMapping("/Teach")
    public String GetRab(Model model)
    {
        Iterable<Teacher> teacher = teacherRepository.findAll();
        model.addAttribute("teacher",teacher);
        return "MainTeach";
    }
    @GetMapping("/Add/Teacher")
    public String GetAddStudent(Teacher teachers,Model model)
    {
        return "Add-Teacher";
    }
    @PostMapping("/Add/Teacher")
    public String blogPostAdd(@ModelAttribute("teacher")@Valid Teacher teacher, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "Add-Teacher";
        }
        teacherRepository.save(teacher);
        return "redirect:/Teach";
    }
    @GetMapping( path = "/Search/Teacher")
    public String blogFilter(Model model)
    {
        return "Search-Teacher";
    }

    @PostMapping("/Search/Teacher-result")
    public String blogResult(@RequestParam String surname, Model model)
    {
        List<Teacher> teach = teacherRepository.findBySurname(surname);
        model.addAttribute("result", teach);
        return "Search-Teacher";
    }
    @PostMapping("/Search/Teacher")
    public String simpleSearch(@RequestParam String surname, Model model)
    {
        List<Teacher> teach = teacherRepository.findBySurnameContains(surname);
        model.addAttribute("result", teach);
        return "Search-Teacher";
    }
    @GetMapping("/Teacher/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        ArrayList<Teacher> res = new ArrayList<>();
        teacher.ifPresent(res::add);
        model.addAttribute("teacher", res);
        if(!teacherRepository.existsById(id))
        {
            return "redirect:/Teach";
        }
        return "Teacher-details";
    }
    @GetMapping("/Teacher/{id}/edit")
    public String blogEdit(@PathVariable("id")long id,
                           Model model)
    {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid teacher Id" + id));
        model.addAttribute("teacher",teacher);
        return "Teacher-edit";

    }
    @PostMapping("/Teacher/{id}/edit")
    public String blogPostUpdate(@ModelAttribute("teacher")@Valid Teacher teacher, BindingResult bindingResult,
                                 @PathVariable("id") long id) {

        teacher.setId(id);
        if (bindingResult.hasErrors()) {
            return "Teacher-edit";
        }
        teacherRepository.save(teacher);
        return "redirect:/Teach";
    }
    @PostMapping("/Teacher/{id}/remove")
    public String blogBlogDelete(@PathVariable("id") long id, Model model){
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
        teacherRepository.delete(teacher);
        return "redirect:/Teach";
    }
}
