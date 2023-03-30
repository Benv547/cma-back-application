package cma.cmabackapplication.controller;

import cma.cmabackapplication.boundary.CourseRessource;
import cma.cmabackapplication.entity.Course;
import cma.cmabackapplication.input.CourseInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class CourseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CourseRessource cr;

    @Test
    public void testGetCourse_ExpectTrue() throws Exception {

        Course course = new Course();
        course.setId("1");
        course.setName("Fake course");
        course.setRoom("Fake room");
        course.setHourlyStart("9:00");
        course.setHourlyFinish("12:00");
        cr.save(course);

        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCourse_ExpectFalse() throws Exception {

        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createCourse_ExpectTrue() throws Exception {

        CourseInput course = new CourseInput();
        course.setName("Fake course");
        course.setRoom("Fake room");
        course.setHourlyStart("9:00");
        course.setHourlyFinish("12:00");

        mockMvc.perform(post("/courses")
                .contentType("application/json")
                .content(toJsonString(course)))
                .andExpect(status().isOk());

    }

    @Test
    public void updateCourse_ExpectTrue() throws Exception {

        Course course = new Course();
        course.setId("1");
        course.setName("Fake course");
        course.setRoom("Fake room");
        course.setHourlyStart("9:00");
        course.setHourlyFinish("12:00");
        cr.save(course);

        CourseInput update = new CourseInput();
        update.setHourlyStart("8:00");

        mockMvc.perform(put("/courses/1")
                .contentType("application/json")
                .content(toJsonString(update)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":\"1\",\"name\":\"Fake course\",\"room\":\"Fake room\",\"hourlyStart\":\"8:00\",\"hourlyFinish\":\"12:00\"}"));
    }

    @Test
    public void deleteCourse_ExpectTrue() throws Exception {

        Course course = new Course();
        course.setId("1");
        course.setName("Fake course");
        course.setRoom("Fake room");
        course.setHourlyStart("9:00");
        course.setHourlyFinish("12:00");
        cr.save(course);

        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/courses/1"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isNotFound());
    }

    private String toJsonString(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r);
    }
}