package cma.cmabackapplication.boundary;

import cma.cmabackapplication.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRessource extends JpaRepository<Course, String> {
}