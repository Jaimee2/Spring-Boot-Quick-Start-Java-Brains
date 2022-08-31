package com.JavaBrains.JavaBrains.Services;


import com.JavaBrains.JavaBrains.Dao.TopicRepository;
import com.JavaBrains.JavaBrains.Models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    //Inyeccion de la dependecia que gestiona la BBDD (ORM) Hibernate
    @Autowired
    TopicRepository topicRepository;
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring framework", "Course of spring boot with Java Braains"),
            new Topic("Java", "Core Java", "Course of Java Core with Java Braains"),
            new Topic("JavaScript", "JavaScrpit", "Course of JavaScript with Java Braains")));


    public List<Topic> getAllTopics() {
        //return topics
        List<Topic> listaTopics = new ArrayList<>();
        topicRepository.findAll().forEach(listaTopics::add);
        return  listaTopics;
    }

    public Topic getTopic(String id) {
        /*return topics.stream().filter(elem -> elem.getId().equals(id)) //Devuelve los elementos que tenga id = id.
                .findFirst() // Obtenemos el primer elmento.
                .get(); //Obtemenso el elemento.
        */

        return topicRepository.findById(id).orElse(null);

    }

    public void addTopic(Topic topic) {
        //topics.add(topic); //Be aware that we need instance of arraylist (new ArrayList <>(....))
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        /*for (int i = 0; i < topics.size(); i++) {
            if (topics.get(i).getId().equals(id)) {
                topics.set(i, topic);
                System.out.println("entro en el if");
                return;
            }
        }*/
        topicRepository.save(topic);//El objeto ya tiene el id por tanto JPA ya sabe que fila actualizar

    }

    public String deleteTopic(String id) {
        try{
            //topics.remove(topics.stream().filter(elem -> elem.getId().equals(id)).findFirst().get());
            topicRepository.deleteById(id);
            return "Topic eliminado";
        }catch (Exception e){
            return "No existe el topic con id: " + id;
        }

    }
}
