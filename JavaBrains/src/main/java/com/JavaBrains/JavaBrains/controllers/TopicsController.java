package com.JavaBrains.JavaBrains.controllers;

import com.JavaBrains.JavaBrains.Models.Topic;
import com.JavaBrains.JavaBrains.Services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicsController {

    //Inyección de dependencia de la capa de negocio
    @Autowired
    TopicService topicService;

    //Get all topics
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
       return topicService.getAllTopics();
    }

    //Gets the topic by id
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    //Create new topic
    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    //Update a topic by id
    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(topic,id);
    }


    //Delete a topic by id
    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public String deleteTopic(@PathVariable String id){
        return topicService.deleteTopic(id);
    }




}
