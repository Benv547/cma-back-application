package cma.cmabackapplication.service;

import cma.cmabackapplication.boundary.CourseRessource;
import cma.cmabackapplication.boundary.StudentRessource;
import cma.cmabackapplication.entity.Course;
import cma.cmabackapplication.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRessource sr;
    @Autowired
    private CourseRessource cr;

    public List<Student> getAllStudents() {
        return sr.findAll();
    }

    public List<Course> getStudentDayCourse(String studentId) {
        return null;
    }

    public Student getStudentById(String studentId) {
        return sr.findById(studentId).orElse(null);
    }

    public Student createStudent(Student student) {
        return sr.save(student);
    }

    public Student updateStudent(Student student) {
        Student currentStudent = sr.findById(student.getId()).get();
        if (student.getName() != null) {
            currentStudent.setName(student.getName());
        }
        if (student.getFirstname() != null) {
            currentStudent.setFirstname(student.getFirstname());
        }
        if (student.getEmail() != null) {
            currentStudent.setEmail(student.getEmail());
        }
        return sr.save(currentStudent);
    }

    public void deleteStudent(String studentId) {
        sr.deleteById(studentId);
    }



}
