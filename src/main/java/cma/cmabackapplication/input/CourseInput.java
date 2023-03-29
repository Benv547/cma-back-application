package cma.cmabackapplication.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInput {

    // TODO: change attributes to match Course entity (Jean)
    private Long id;
    private String name;
    private String description;
    private String teacher;
}
