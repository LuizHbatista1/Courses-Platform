package com.api.lessons.controller;


import com.api.lessons.DTO.LessonDTO;
import com.api.lessons.domain.Lesson;
import com.api.lessons.service.LessonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/create")
    public ResponseEntity<Lesson>createLesson(@RequestBody LessonDTO lessonDTO){

        Lesson newLesson =  lessonService.createLesson(lessonDTO);
        return new ResponseEntity<>(newLesson , HttpStatus.CREATED);

    }


}
