package cma.cmabackapplication.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    private String id;
    private String name;
    private String hourlyStart;
    private String hourlyFinish;
    private String room;
}