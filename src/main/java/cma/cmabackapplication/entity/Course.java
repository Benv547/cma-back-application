package cma.cmabackapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String hourlyStart;
    private String hourlyFinish;
    private String room;
}