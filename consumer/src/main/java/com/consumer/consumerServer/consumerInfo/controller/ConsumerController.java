package com.consumer.consumerServer.consumerInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.consumerServer.consumerInfo.entity.Consumer;
import com.consumer.consumerServer.consumerInfo.service.ConsumerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class ConsumerController {
    @Autowired

    public ConsumerService consumerServiceObject;

    @PostMapping("/consumer")
    public Consumer saveConsumer(@RequestBody Consumer consumer) {
        return consumerServiceObject.saveConsumer(consumer);
    }

    @GetMapping("/consumer")
    public List<Consumer> getAllConsumers() {
        // log.info("inside post information - info");
        // log.debug("inside post information- debug");
        // log.warn("inside post information - warn");
        // log.error("inside post information - error");
        // log.trace("inside post - trace");
        return consumerServiceObject.fetchAllConsumers();
    }

    @GetMapping("/consumer/{id}")
    public Consumer getConsumerById(@PathVariable("id") int id) {
        return consumerServiceObject.getConsumerById(id);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteConsumerOrderById(@PathVariable("id") int id) {
        consumerServiceObject.deleteConsumerOrderById(id);
    }

    // @GetMapping("/consumer/{id}")
    // public Consumer getConsumerOrderById(@PathVariable("id") int id) {
    // return consumerServiceObject.getConsumerOrderById(id);
    // }
}
