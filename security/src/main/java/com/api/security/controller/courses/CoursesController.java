package com.api.security.controller.courses;


import com.api.courses.DTO.CoursesDTO;
import com.api.courses.domain.Courses;
import com.api.courses.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @PostMapping
    public ResponseEntity<Courses>createCourses(@RequestBody @Validated CoursesDTO coursesDTO){

        Courses newCourses =  coursesService.createCourses(coursesDTO);
        return new ResponseEntity<>(newCourses , HttpStatus.CREATED);


    }

}
