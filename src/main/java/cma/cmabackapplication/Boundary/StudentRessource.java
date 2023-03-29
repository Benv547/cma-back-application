package cma.cmabackapplication.Boundary;

import cma.cmabackapplication.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRessource extends JpaRepository<Student, String> {
}
