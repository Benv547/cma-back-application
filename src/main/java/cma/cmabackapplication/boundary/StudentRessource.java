package cma.cmabackapplication.boundary;

import cma.cmabackapplication.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRessource extends JpaRepository<Student, String> {
}