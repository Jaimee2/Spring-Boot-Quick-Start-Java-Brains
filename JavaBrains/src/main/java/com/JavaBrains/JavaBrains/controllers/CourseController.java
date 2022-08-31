package com.JavaBrains.JavaBrains.controllers;

import com.JavaBrains.JavaBrains.Models.Course;
import com.JavaBrains.JavaBrains.Models.Topic;
import com.JavaBrains.JavaBrains.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {


    //Inyección de dependencia de la capa de negocio
    @Autowired
    CourseService courseService;

    //Get all course
    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourse(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
    }

    //Gets the course by id
    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String topicId, @PathVariable String courseId){
        return courseService.getCourse(courseId);
    }

    //Create new course
    /**
     * http://localhost:8080/topics/Jquery/courses hacemos un post
     * El topicId es --> Jquery SI NO EXISTE UN topicId = Jquery en la tabla topics no lo podemos crear
     *
     * **/
    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@PathVariable String topicId,@RequestBody Course course){
        System.out.println("hola entro en addCourse");
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    //Update a course by id
    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId){
        System.out.println("Entor aquie???");
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course,topicId);
    }


    //Delete a topic by id
    @RequestMapping(value = "/topics/courses/{courseId}", method = RequestMethod.DELETE)
    public String deleteCourse(@PathVariable String courseId){
        System.out.println("entro");
        return courseService.deleteCourse(courseId);
    }


}
