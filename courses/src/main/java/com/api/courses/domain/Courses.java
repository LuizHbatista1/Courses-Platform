package com.api.courses.domain;


import com.api.courses.DTO.CoursesDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "courses")
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private String description;
    private Double price;




    public Courses (CoursesDTO data){

        this.title = data.title();
        this.description = data.description();
        this.price = data.price();


    }

}
