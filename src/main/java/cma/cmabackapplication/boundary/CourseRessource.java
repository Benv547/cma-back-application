package cma.cmabackapplication.boundary;

import cma.cmabackapplication.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRessource extends JpaRepository<Course, String> {
}
