package com.api.lessons.service;


import com.api.courses.domain.Courses;
import com.api.courses.service.CoursesService;
import com.api.lessons.DTO.LessonDTO;
import com.api.lessons.domain.Lesson;
import com.api.lessons.infra.exceptions.IdNotFoundException;
import com.api.lessons.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CoursesService coursesService;

    public Lesson findLessonById(Long id){

       return this.lessonRepository.findById(id).orElseThrow(()-> new RuntimeException(new IdNotFoundException(id)));

    }

    public Lesson createLesson(LessonDTO lessonDTO){

        Courses newCourses = coursesService.findCoursesById(lessonDTO.courseId());
        Lesson newLesson = new Lesson(lessonDTO);
        newLesson.setNameLesson(lessonDTO.nameLesson());
        newLesson.setContent(lessonDTO.content());
        newLesson.setCourses(newCourses);
        this.saveLesson(newLesson);
        return newLesson;

    }

    public void saveLesson (Lesson lesson){

        this.lessonRepository.save(lesson);

    }

}
