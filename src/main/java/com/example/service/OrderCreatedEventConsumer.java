//package com.example.service;
//
//import com.example.orderservice.dto.OrderCreatedEvent;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.listener.MessageListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class OrderCreatedEventConsumer implements MessageListener<Integer, OrderCreatedEvent> {
//
////    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "order-creation-events-consumer-1")
////    @Override
////    public void onMessage(ConsumerRecord<Integer, String> data) {
////        log.info("Received message {}",data);
////
////        Long productId = Long.parseLong(data.value());
////
////        log.info("Decreasing product '{}' quantity by 1...", productId);
////    }
//
//    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "order-creation-events-consumer-1")
//    @Override
//    public void onMessage(ConsumerRecord<Integer, OrderCreatedEvent> data) {
//        log.info("Received message {}",data);
//        log.info("Decreasing product '{}' quantity by 1...", data.value().getProductIds());
//    }
//}
