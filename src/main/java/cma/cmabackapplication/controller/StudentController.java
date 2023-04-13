package cma.cmabackapplication.controller;

import cma.cmabackapplication.entity.Course;
import cma.cmabackapplication.entity.Student;
import cma.cmabackapplication.input.CourseInput;
import cma.cmabackapplication.input.StudentInput;
import cma.cmabackapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String studentId) {
        Student s = studentService.getStudentById(studentId);
        if (s == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(s);
    }

    @GetMapping("/{studentId}/day-course")
    public ResponseEntity<Object> getStudentDayCourse(@PathVariable String studentId) {
        List<Course> studentCourses = studentService.getStudentDayCourse(studentId);
        return ResponseEntity.ok(studentCourses);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentInput student) {
        Student s = new Student();
        s.setName(student.getName());
        s.setFirstname(student.getFirstname());
        s.setEmail(student.getEmail());
        return ResponseEntity.ok(studentService.createStudent(s));
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable String studentId, @RequestBody StudentInput student) {
        Student s = new Student();
        s.setId(studentId);
        s.setName(student.getName());
        s.setFirstname(student.getFirstname());
        s.setEmail(student.getEmail());
        return ResponseEntity.ok(studentService.updateStudent(s));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }

}
