package cma.cmabackapplication.service;

import cma.cmabackapplication.boundary.CourseRessource;
import cma.cmabackapplication.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRessource ressource;

    public Course getCourseById(String courseId) {
        return ressource.findById(courseId).orElse(null);
    }

    public Course createCourse(Course course) {
        return ressource.save(course);
    }

    public Course updateCourse(Course course) {
        Course currentCourse = ressource.findById(course.getId()).get();
        if (course.getName() != null) {
            currentCourse.setName(course.getName());
        }
        if (course.getRoom() != null) {
            currentCourse.setRoom(course.getRoom());
        }
        if (course.getHourlyStart() != null) {
            currentCourse.setHourlyStart(course.getHourlyStart());
        }
        if (course.getHourlyFinish() != null) {
            currentCourse.setHourlyFinish(course.getHourlyFinish());
        }
        return ressource.save(currentCourse);
    }

    public void deleteCourse(String courseId) {
        ressource.deleteById(courseId);
    }

    public List<Course> getAllCourses() {
        return ressource.findAll();
    }
}
