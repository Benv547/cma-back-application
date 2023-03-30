package cma.cmabackapplication.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInput {

    private String name;
    private String hourlyStart;
    private String hourlyFinish;
    private String room;

}
