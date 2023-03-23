package com.example.study1;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class StudentMap {

    private final List<Student> studentList = new ArrayList<>();
}
