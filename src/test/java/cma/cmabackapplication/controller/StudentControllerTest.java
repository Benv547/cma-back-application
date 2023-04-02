package cma.cmabackapplication.controller;

import cma.cmabackapplication.boundary.CourseRessource;
import cma.cmabackapplication.boundary.StudentRessource;
import cma.cmabackapplication.entity.Course;
import cma.cmabackapplication.entity.Student;
import cma.cmabackapplication.input.CourseInput;
import cma.cmabackapplication.input.StudentInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRessource ressource;

    @Test
    public void testGetDayCourse() throws Exception {
        mockMvc.perform(get("/students/1/day-course"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStudent_ExpectTrue() throws Exception {

        Student student = new Student();
        student.setId("1");
        student.setName("Fake name");
        student.setFirstname("Fake firstname");
        student.setEmail("Fake email");
        ressource.save(student);

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStudent_ExpectFalse() throws Exception {
        mockMvc.perform(get("/students/aecde-80820"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateStudent_ExpectTrue() throws Exception {

        Student student = new Student();
        student.setId("1");
        student.setName("Fake name");
        student.setFirstname("Fake firstname");
        student.setEmail("Fake email");
        ressource.save(student);

        StudentInput update = new StudentInput();
        update.setName("New fake name");

        mockMvc.perform(put("/students/1")
                        .contentType("application/json")
                        .content(toJsonString(update)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":\"1\",\"name\":\"New fake name\",\"firstname\":\"Fake firstname\",\"email\":\"Fake email\"}"));
    }

    @Test
    public void deleteStudent_ExpectTrue() throws Exception {

        Student student = new Student();
        student.setId("1");
        student.setName("Fake name");
        student.setFirstname("Fake firstname");
        student.setEmail("Fake email");
        ressource.save(student);

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/students/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/students/1"))
                .andExpect(status().isNotFound());
    }

    private String toJsonString(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r);
    }
}