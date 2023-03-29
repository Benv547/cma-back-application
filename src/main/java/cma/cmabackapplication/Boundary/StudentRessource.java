package cma.cmabackapplication.Entity.Boundary;

import cma.cmabackapplication.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRessource extends JpaRepository<Student, String> {
}
