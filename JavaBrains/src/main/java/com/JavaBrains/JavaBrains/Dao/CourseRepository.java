package com.JavaBrains.JavaBrains.Dao;

import com.JavaBrains.JavaBrains.Models.Course;
import com.JavaBrains.JavaBrains.Models.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository  extends CrudRepository<Course,String> {

    public List<Course> findByTopicId(String topicId); //Se implemente automaticamente La clave es definir bien el nombre de la clase
}
