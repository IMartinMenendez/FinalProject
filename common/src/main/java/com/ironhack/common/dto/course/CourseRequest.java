package com.ironhack.common.dto.course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {

    @Getter
    @Setter
    private Long creatorId;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String link;
    @Getter
    @Setter
    private String picture;
}
