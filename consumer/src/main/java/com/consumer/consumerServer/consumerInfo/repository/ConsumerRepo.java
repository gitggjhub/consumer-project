package com.consumer.consumerServer.consumerInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumer.consumerServer.consumerInfo.entity.Consumer;

@Repository
public interface ConsumerRepo extends JpaRepository<Consumer, Integer> {
    // You can add custom queries here if needed
}
