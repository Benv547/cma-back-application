package cma.cmabackapplication.boundary;

import cma.cmabackapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRessource extends JpaRepository<Student, String> {
}
