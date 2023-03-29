package cma.cmabackapplication.controller;

import cma.cmabackapplication.entity.Course;
import cma.cmabackapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{studentId}/day-course")
    public ResponseEntity<Object> getStudentDayCourse(@PathVariable Long studentId) {
        List<Course> studentCourses = studentService.getStudentDayCourse(studentId);
        return ResponseEntity.ok(studentCourses);
    }

}
