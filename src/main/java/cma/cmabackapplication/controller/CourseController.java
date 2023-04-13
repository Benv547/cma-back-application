package cma.cmabackapplication.controller;

import cma.cmabackapplication.entity.Course;
import cma.cmabackapplication.input.CourseInput;
import cma.cmabackapplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<Iterable<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable String courseId) {
        Course c = courseService.getCourseById(courseId);
        if (c == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseInput course) {
        Course c = new Course();
        c.setName(course.getName());
        c.setRoom(course.getRoom());
        c.setHourlyFinish(course.getHourlyFinish());
        c.setHourlyStart(course.getHourlyStart());
        return ResponseEntity.ok(courseService.createCourse(c));
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable String courseId, @RequestBody CourseInput course) {
        Course c = new Course();
        c.setId(courseId);
        c.setName(course.getName());
        c.setRoom(course.getRoom());
        c.setHourlyFinish(course.getHourlyFinish());
        c.setHourlyStart(course.getHourlyStart());
        return ResponseEntity.ok(courseService.updateCourse(c));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok().build();
    }

}
