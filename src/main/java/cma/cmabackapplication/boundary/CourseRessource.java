package cma.cmabackapplication.boundary;

import cma.cmabackapplication.entity.Course;
import cma.cmabackapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CourseRessource extends JpaRepository<Course, String> {}
