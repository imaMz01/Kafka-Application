package com.Peaqock.Kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sedMessage(String msg){
        log.info(String.format("Sending message to ImaMz::%s",msg));
        kafkaTemplate.send("ImaMz",msg);
    }
}
