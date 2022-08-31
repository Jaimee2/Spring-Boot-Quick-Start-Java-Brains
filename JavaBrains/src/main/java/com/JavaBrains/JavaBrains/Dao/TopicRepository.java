package com.JavaBrains.JavaBrains.Dao;


import com.JavaBrains.JavaBrains.Models.Topic;
import org.springframework.data.repository.CrudRepository;

//Obtenemos todos los metodos necesarios para hacer un CRUD con la BBDD
public interface TopicRepository extends CrudRepository<Topic,String> { }
