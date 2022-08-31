package com.JavaBrains.JavaBrains.Services;

import com.JavaBrains.JavaBrains.Dao.CourseRepository;
import com.JavaBrains.JavaBrains.Dao.CourseRepository;
import com.JavaBrains.JavaBrains.Models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class CourseService {

    //Inyeccion de la dependecia que gestiona la BBDD (ORM) Hibernate
    @Autowired
    CourseRepository courseRepository;


    public List<Course> getAllCourses(String topicId) {
        List<Course> listaCourses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(listaCourses::add);
        return  listaCourses;
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course) {

        courseRepository.save(course);
    }

    public void updateCourse(Course course, String id) {
        System.out.println("Entro");
        courseRepository.save(course);//El objeto ya tiene el id por tanto JPA ya sabe que fila actualizar
    }

    //NO FUNCIONA CORRECTAMENTE!!!!!!!!!!!!!!!!
    public String deleteCourse(String cursoId) {
        try {
            courseRepository.deleteById(cursoId);
            return "Course eliminado";
        } catch (Exception e) {
            return "No existe el course con id: " + cursoId;
        }

    }
}
