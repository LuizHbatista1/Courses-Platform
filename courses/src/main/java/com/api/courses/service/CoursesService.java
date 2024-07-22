package com.api.courses.service;


import com.api.courses.DTO.CoursesDTO;
import com.api.courses.domain.Courses;
import com.api.courses.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;


    public Courses findCoursesById(Long id){

        return this.coursesRepository.findById(id).orElseThrow(()-> new RuntimeException());

    }

    public Courses createCourses(CoursesDTO coursesDTO){

        Courses newCourses = new Courses(coursesDTO);
        newCourses.setTitle(newCourses.getTitle());
        newCourses.setDescription(newCourses.getDescription());
        newCourses.setPrice(newCourses.getPrice());
        this.saveCourse(newCourses);
        return newCourses;

    }

    public void saveCourse(Courses courses){

        this.coursesRepository.save(courses);

    }

}
