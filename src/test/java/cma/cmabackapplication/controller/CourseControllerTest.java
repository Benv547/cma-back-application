package cma.cmabackapplication.controller;

import cma.cmabackapplication.input.CourseInput;
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
public class CourseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCourse_ExpectTrue() throws Exception {
        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void createCourse_ExpectTrue() throws Exception {

        CourseInput course = new CourseInput();

        mockMvc.perform(post("/courses")
                .contentType("application/json")
                .content(toJsonString(course)))
                .andExpect(status().isOk());

    }

    @Test
    public void updateCourse_ExpectTrue() throws Exception {

        CourseInput course = new CourseInput();

        mockMvc.perform(post("/courses")
                .contentType("application/json")
                .content(toJsonString(course)))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteCourse_ExpectTrue() throws Exception {
        mockMvc.perform(delete("/courses/1"))
                .andExpect(status().isOk());
    }

    private String toJsonString(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r);
    }
}