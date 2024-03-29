package com.consumer.consumerServer.consumerInfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumer.consumerServer.consumerInfo.entity.Consumer;
import com.consumer.consumerServer.consumerInfo.repository.ConsumerRepo;

@Service
public class ConsumerService {

    @Autowired

    public ConsumerRepo ConsumerRepoObject;
    
    public Consumer saveConsumer(Consumer Consumer){
        return ConsumerRepoObject.save(Consumer);
    }

    public List<Consumer>fetchAllConsumers(){
        List<Consumer> allConsumers = ConsumerRepoObject.findAll();
        return allConsumers;
    }

    public Consumer getConsumerById(int id) {
        Optional<Consumer> consumer = ConsumerRepoObject.findById(id);
        if (consumer.isPresent()) {
            return consumer.get();
        }
        return null;
    }
    public void deleteConsumerById(int id) {
        if (ConsumerRepoObject.findById(id).isPresent()) {
            ConsumerRepoObject.deleteById(id);
        }
    }

    public void deleteConsumerOrderById(int id){
        if(ConsumerRepoObject.findById(id).isPresent()){
            ConsumerRepoObject.deleteById(id);
        }
    }

    // public Consumer getConsumerOrderById(int id) {
    //     Optional<Consumer> consumer = ConsumerRepoObject.findById(id);
    //     if (consumer.isPresent()) {
    //         return consumer.consumerOrder.get();
    //     }
    // }  
}
