package com.example.study1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Controller
public class StudentController {

    private final StudentMap studentMap;

    @GetMapping("/")
    public String getStudents(Model model) {
        model.addAttribute("students", studentMap.getStudentList());
        for (Student student : studentMap.getStudentList()) {
            log.info(student.getName());
        }
        return "index";
    }

    @PostMapping("/students")
    public String register(Student student) {
        studentMap.getStudentList().add(student);
        return "redirect:/";
    }

    @PostMapping("/students/delete")
    public String delete(String name) {
        studentMap.getStudentList().removeIf(student -> Objects.equals(student.getName(), name));
        return "redirect:/";
    }
}
