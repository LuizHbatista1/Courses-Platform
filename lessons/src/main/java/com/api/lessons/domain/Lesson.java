package com.api.lessons.domain;

import com.api.courses.domain.Courses;
import com.api.lessons.DTO.LessonDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "lessons")
@Table(name = "lessons")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")

public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nameLesson;
    private String content;
    @JoinColumn(name = "course_id")
    @ManyToOne
    private Courses courses;

    public Lesson (LessonDTO data){

        this.nameLesson = data.nameLesson();
        this.content = data.content();
        this.courses = courses;

    }

}
