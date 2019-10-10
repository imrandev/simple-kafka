package com.nexkraft.kafka.SimpleKafka.listener;

import com.nexkraft.kafka.SimpleKafka.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    @KafkaListener(topics = "kafka-sample", containerGroup = "kafka-group")
    public void consumer(User user){
        System.out.println(String.format("Consumed Message : %s", user));
    }
}
