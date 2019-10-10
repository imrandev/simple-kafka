package com.nexkraft.kafka.SimpleKafka.rest;

import com.nexkraft.kafka.SimpleKafka.model.User;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka")
public class UserController {

    private KafkaTemplate<String, User> kafkaTemplate;
    private NewTopic topic;

    @Autowired
    public UserController(KafkaTemplate<String, User> kafkaTemplate, NewTopic topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @GetMapping("/user/{name}")
    public User send(@PathVariable("name") String name, @RequestParam("m") String message){
        User user = new User(name, message);
        kafkaTemplate.send(topic.name(), user);
        return user;
    }

    @GetMapping("/user/messages")
    public User receive(User user){
        return user;
    }
}
