package cma.cmabackapplication.controller;

import cma.cmabackapplication.entity.Course;
import cma.cmabackapplication.input.CourseInput;
import cma.cmabackapplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseInput course) {
        Course c = new Course();
        return ResponseEntity.ok(courseService.createCourse(c));
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody CourseInput course) {
        Course c = new Course();
        return ResponseEntity.ok(courseService.updateCourse(c));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok().build();
    }

}
