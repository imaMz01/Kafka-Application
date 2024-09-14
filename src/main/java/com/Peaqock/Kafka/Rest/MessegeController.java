package com.Peaqock.Kafka.Rest;

import com.Peaqock.Kafka.payload.Student;
import com.Peaqock.Kafka.producer.KafkaJsonProducer;
import com.Peaqock.Kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessegeController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;
    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        kafkaProducer.sedMessage(message);
        return  ResponseEntity.ok("Message queued successfuly");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendMessageAsJson(@RequestBody Student message){
        kafkaJsonProducer.sendMessage(message);
        return  ResponseEntity.ok("Message queued successfuly");
    }
}
