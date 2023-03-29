package cma.cmabackapplication;

import cma.cmabackapplication.Boundary.CourseRessource;
import cma.cmabackapplication.Entity.Course;
import cma.cmabackapplication.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CmaBackApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testEntity() {
		Course c = new Course("id", "name", "start", "finish", "room");
		Student s = new Student("id", "name", "fname", "email");
		assert(c.getId().equals("id"));
		assert(s.getId().equals("id"));
	}

}
